Cozly1.0支持的功能
1.支持@FormBean与struts-config.xml中的FormBean进行对应
2.通过初始化的时候自动添加一个ForwardConfig，把Method的名字对应的path绑定在SUCCESS上
3.提供一个全局的redrect，返回到一个redrect的jsp上，而这个jsp自动在几秒后refresh，所以自动再到另一个页面
Cozly1.1支持的功能
1.提供@FormProperties，可以在Method处填写，需要得到的Form所需要的property name
2.提供一个默认的sparklie.properties在WEB-INF上，里面可以先存在一些或者说有的properties name，于是可以在Method处
不申明FormProperties，而使用这个默认的FormBean配置
3.重构了代码，提供MoldyBill风格存取数据方式
说明：　	String $(String key)   	在Form中取String
		String $s(String key)	...取String
		Object $$(String key)	...取Object
		Object $o(String key)	...取Object
		Integer $i(String key)	...取Integer
		
		void _(String key,Object value) 向Request中设置Attributes  
		void _r(String key,Object value) 同上
		void _s(String key,Object,value) 向Session中设置Attributes