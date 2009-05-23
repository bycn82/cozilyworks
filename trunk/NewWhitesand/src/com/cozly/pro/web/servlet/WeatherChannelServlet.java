package com.cozly.pro.web.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.XML;

import com.cozly.util.MD5Util;


/**
 * Servlet implementation class for Servlet: WeatherChannelServlet
 * 
 */
public class WeatherChannelServlet extends javax.servlet.http.HttpServlet
		implements javax.servlet.Servlet {

	private static final long serialVersionUID = 1L;

	private String licenseId;

	private String partnerId;

	private int debug;

	private String cacheDir;

	private long cacheLife;

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}

	private void doRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String locationId = request.getParameter("locid");
		if (this.debug > 0) {
			this.log("Weather requested for location:" + locationId);
		}
		String callback = request.getParameter("callback");
		if (callback == null || callback.length() == 0) {
			callback = "onWeatherData";
		}
		if (this.debug > 0) {
			this.log("Client side callback method:" + callback);
		}
		int forcastDays;
		try {
			forcastDays = Integer.parseInt(request.getParameter("days"));
		} catch (NumberFormatException e) {
			forcastDays = 10;
		}
		if (this.debug > 0) {
			this.log("Forecast days:" + forcastDays);
		}
		String url = "http://xoap.weather.com/weather/local/" + locationId
				+ "?cc=*&dayf=" + forcastDays + "&prod=xoap&par=" + partnerId
				+ "&key=" + licenseId;
		if (request.getParameter("m") != null) {
			url += "&unit=m";
		} else {
			url += "&unit=s";
		}
		if (this.debug > 0) {
			this.log("Weather.com URL:" + url);
		}
		try {
			String xml = loadDataXml(url);
			response.setContentType("text/javascript;charset=utf-8");
			StringBuffer js = new StringBuffer();
			String varName = "_wd" + System.currentTimeMillis();
			js.append("var " + varName + " = ");
			if (xml == null || xml.length() == 0) {
				js.append("null");
			} else {
				if (this.debug == 1) {
					js.append(XML.toJSONObject(xml).toString(4));
				} else {
					js.append(XML.toJSONObject(xml).toString());
				}
			}
			js.append(";");
			js.append("if (" + varName + " && " + varName + ".weather){");
			js.append(callback + "(");
			js.append(varName + ".weather");
			js.append(");");
			js.append("}else{");
			js.append(callback + "(");
			js.append(varName);
			js.append(");");
			js.append("}");
			response.getWriter().write(js.toString());
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @param url
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	private String loadDataXml(String url) {
		// try to load from cache first
		String cachePath = this.getServletContext().getRealPath(this.cacheDir);
		String hash = MD5Util.MD5(url);
		File cached = new File(cachePath, hash);
		if (cached.exists() && !outOfDated(cached)) {
			String loadDataFromCache;
			try {
				loadDataFromCache = loadDataFromCache(cached);
			} catch (IOException e) {
				loadDataFromCache = null;
			}
			if (loadDataFromCache != null
					// A quick test to see if we got validated weather data
					// We should include xml dtd validation in feature.
					&& loadDataFromCache.indexOf("ver") != -1)
				return loadDataFromCache;
		}
		// if cached version is out of date or cant find
		// one, load data from remote
		String data = loadDataFromRemote(url);
		try {
			writeDataToCache(data, cached);
		} catch (IOException e) {
			// do nothing
		}
		return data;
	}

	/**
	 * @param data
	 * @param cached
	 * @throws IOException
	 */
	private void writeDataToCache(String data, File cached) throws IOException {
		if (data == null || cached == null)
			return;
		if (!cached.getParentFile().exists()) {
			cached.getParentFile().mkdirs();
		}
		if (!cached.exists())
			cached.createNewFile();
		try {
			PrintWriter writer = new PrintWriter(cached);
			writer.write(data);
			writer.close();
		} catch (FileNotFoundException e) {
			return;
		}
	}

	/**
	 * @param cached
	 * @return
	 * @throws IOException
	 */
	private String loadDataFromCache(File cached) throws IOException {
		try {
			StringBuffer sb = new StringBuffer();
			BufferedReader br = new BufferedReader(new FileReader(cached));
			String line = null;
			try {
				while ((line = br.readLine()) != null) {
					sb.append(line);
					sb.append("\n");
				}
				return sb.toString().trim();
			} finally {
				br.close();
				br = null;
			}
		} catch (FileNotFoundException e) {
			return null;
		}
	}

	/**
	 * @param cached
	 * @return
	 */
	private boolean outOfDated(File cached) {
		long current = System.currentTimeMillis();
		return (current - cached.lastModified()) > this.cacheLife;
	}

	/**
	 * @param url
	 * @return
	 */
	private String loadDataFromRemote(String url) {
		URL requestUrl;
		try {
			requestUrl = new URL(url);
		} catch (MalformedURLException e) {
			return null;
		}
		InputStream inputStream = null;
		try {
			inputStream = requestUrl.openStream();
			int ch;
			StringBuffer sb = new StringBuffer();
			while ((ch = inputStream.read()) != -1)
				sb.append((char) ch);
			return sb.toString().trim();
		} catch (IOException e) {
			return null;
		} finally {
			try {
				if (inputStream != null)
					inputStream.close();
			} catch (IOException e) {
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.GenericServlet#init()
	 */
	public void init() throws ServletException {
		super.init();
		if (this.getInitParameter("debug") != null) {
			try {
				this.debug = Integer.valueOf(this.getInitParameter("debug"));
			} catch (NumberFormatException e) {
				this.debug = 0;
			}
		} else {
			this.debug = 0;
		}
		// init license id
		this.licenseId = this.getInitParameter("license_id");
		if (licenseId == null) {
			throw new ServletException(
					"License ID is required, plz contact weather.com to get one!");
		}
		if (this.debug > 0) {
			this.log("Weather.com License Id:" + licenseId);
		}
		// init partner id
		this.partnerId = this.getInitParameter("partner_id");
		if (partnerId == null) {
			throw new ServletException(
					"Partner ID is required, plz contact weather.com to get one!");
		}
		if (this.debug > 0) {
			this.log("Weather.com Partner Id:" + partnerId);
		}

		// init cache directory
		this.cacheDir = this.getInitParameter("cache_dir");
		if (this.cacheDir == null) {
			this.cacheDir = "/WEB-INF/cache";
		}
		if (this.debug > 0) {
			this.log("Weather Data Cached in:" + this.cacheDir);
		}

		// init cache life
		String tmpCacheLife = this.getInitParameter("cache_life");
		if (tmpCacheLife == null || !tmpCacheLife.matches("[0-9]+(s|m|h|d)")) {
			this.cacheLife = 3600000;
			if (this.debug > 0) {
				this.log("Weather Data Cached Life: default = "
						+ this.cacheLife);
			}
		} else {
			long unit = 1000;
			switch (tmpCacheLife.charAt(tmpCacheLife.length() - 1)) {
			case 's': // second
				unit = 1000;
				break;
			case 'm': // minute
				unit = 60000;
				break;
			case 'h': // hour
				unit = 3600000;
				break;
			case 'd': // day
				unit = 3600000 * 24;
				break;
			}
			int number;
			try {
				number = Integer.parseInt(tmpCacheLife.substring(0,
						tmpCacheLife.length() - 1));
			} catch (NumberFormatException e) {
				number = 1;
			}
			this.cacheLife = number * unit;

			if (this.debug > 0) {
				this.log("Weather Data Cached Life: " + this.cacheLife);
			}
		}
	}
}