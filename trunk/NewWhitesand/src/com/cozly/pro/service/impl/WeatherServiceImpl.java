package com.cozly.pro.service.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.servlet.ServletContext;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import org.springframework.web.context.ServletContextAware;

import com.cozly.util.MD5Util;



public class WeatherServiceImpl implements com.cozly.pro.service.WeatherService, ServletContextAware {
	String[] CITIES = { "CHXX0116", "CHXX0008", "CHXX0010", "CHXX0013",
			"CHXX0015", "CHXX0017", "CHXX0019", "CHXX0028", "CHXX0029",
			"CHXX0031", "CHXX0037", "CHXX0039", "CHXX0044", "CHXX0046",
			"CHXX0049", "CHXX0053", "CHXX0063", "CHXX0064", "CHXX0068",
			"CHXX0072", "CHXX0076", "CHXX0079", "CHXX0080", "CHXX0086",
			"CHXX0099", "CHXX0100", "CHXX0101", "CHXX0110", "CHXX0114",
			"CHXX0005", "CHXX0117", "CHXX0119", "CHXX0120", "CHXX0122",
			"CHXX0129", "CHXX0133", "CHXX0135", "CHXX0138", "CHXX0140",
			"CHXX0141", "CHXX0143", "CHXX0148", "CHXX0165", "CHXX0203",
			"CHXX0236", "CHXX0251", "CHXX0259", "CHXX0278", "CHXX0286",
			"CHXX0291", "CHXX0300", "CHXX0308", "CHXX0351", "CHXX0362",
			"CHXX0370", "CHXX0371", "CHXX0407", "CHXX0411", "CHXX0434",
			"CHXX0437", "CHXX0462", "CHXX0467", "CHXX0479", "CHXX0493",
			"CHXX0502", "TWXX0009", "TWXX0013", "TWXX0019", "TWXX0021" };

	ServletContext context;

	public void freshWeatherData() {
		System.out.println("begin");
		for (int j = 0; j < this.CITIES.length; j++) {
			this.freshWeatherDataOfOneCity(CITIES[j], 1, "m");
			this.freshWeatherDataOfOneCity(CITIES[j], 1, "s");
			this.freshWeatherDataOfOneCity(CITIES[j], 10, "m");
			this.freshWeatherDataOfOneCity(CITIES[j], 10, "s");
		}
		System.out.println("end");
	}

	public void freshWeatherDataOfOneCity(String city, int day, String unit) {

		String url = "http://xoap.weather.com/weather/local/" + city+ "?cc=*&dayf=" + day+ "&prod=xoap&par=1018418101&key=db1245716f02e943&unit=" + unit;
		String hash = MD5Util.MD5(url);
		String cachePath = this.context.getRealPath("WEB-INF/cache");
		File cached = new File(cachePath, hash);
		Document ndoc = null;
		Document odoc = null;
		try {
			String data = loadDataFromRemote(url);
			SAXBuilder builder = new SAXBuilder();
			// try to get the new document
			try {
				ndoc = builder.build(new StringReader(data));
			} catch (JDOMException e1) {
				System.out.println("It's not a XML File .oOo.");
			} catch (IOException e1) {
				System.out.println("Exception when IO .oOo.");
			}

			System.out.print(".");
			

			// 如果文件没有，那么就没对比
			if (cached.exists()) {
				try {
					odoc = builder.build(cached);

				} catch (JDOMException e) {
					System.out.println("It's not a XML File .oOo.");
				} catch (IOException e) {

					System.out.println("Exception when IO .oOo.");
				}

				List ols = odoc.getRootElement().getChild("dayf").getChildren(
						"day");
				List nls = ndoc.getRootElement().getChild("dayf").getChildren(
						"day");
				try {
					// 循环修改后10天的天气情况
					for (int i = 0; i < nls.size(); i++) {
						// 修改rootElement>dayf>day[]>hi
						String str = ((Element) nls.get(i)).getChild("hi")
								.getValue();
						if (str.equalsIgnoreCase("N/A")) {
							((Element) nls.get(i)).getChild("hi").setText(
									((Element) ols.get(i)).getChild("hi")
											.getValue());
						}
						// 修改rootElement>dayf>day[]>low
						String str2 = ((Element) nls.get(i)).getChild("low")
								.getValue();
						if (str2.equalsIgnoreCase("N/A")) {
							((Element) nls.get(i)).getChild("low").setText(
									((Element) ols.get(i)).getChild("low")
											.getValue());
						}
						// 修改当天天气,天气分2部分，part0 part1
						String weather1 = ((Element) ((((Element) nls.get(i))
								.getChildren("part")).get(0))).getChild("t")
								.getValue();
						if (weather1.equalsIgnoreCase("N/A")) {
							((Element) ((((Element) nls.get(i))
									.getChildren("part")).get(0)))
									.getChild("t").setText(
											((Element) ((((Element) ols.get(i))
													.getChildren("part"))
													.get(0))).getChild("t")
													.getValue());
						}

						String weather2 = ((Element) ((((Element) nls.get(i))
								.getChildren("part")).get(1))).getChild("t")
								.getValue();
						if (weather2.equalsIgnoreCase("N/A")) {
							((Element) ((((Element) nls.get(i))
									.getChildren("part")).get(1)))
									.getChild("t").setText(
											((Element) ((((Element) ols.get(i))
													.getChildren("part"))
													.get(1))).getChild("t")
													.getValue());
						}

					}
				} catch (Exception e) {
					System.out.println("Exception.oOo.");
				}

			}
			// add the new document into the cache
			try {
				outputToFile(ndoc, cachePath, hash);
			} catch (IOException e) {

				e.printStackTrace();
			}
		} catch (Exception ne) {
			System.out.println(".oOo.");
			//cached.delete();
		}

	}

	public String loadDataFromRemote(String url) {
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

	public void outputToFile(Document doc, String filePath, String fileName)
			throws IOException {
		File oldFile = new File(filePath, fileName);
		if (oldFile.exists()) {
			oldFile.deleteOnExit();
		}
		XMLOutputter outputter = new XMLOutputter();
		FileWriter writer = new FileWriter(new File(filePath, fileName));
		outputter.output(doc, writer);
		writer.close();
	}

	public void setServletContext(ServletContext arg0) {
		this.context = arg0;
	}
}