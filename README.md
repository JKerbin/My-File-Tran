# -api-
使用java编写的基于百度api的文档翻译器

一、	程序的运行环境、安装步骤
1. 运行环境：JDK17；
2. 程序的组成部分：MyFileTran.jar不需要第三方组件库；
3. 安装步骤：

	（1）进入Java官方网站，点击免费java下载，之后点击同意并开始免费下载；
	![image](https://user-images.githubusercontent.com/81380030/194013631-4e8cec55-e9af-44ef-9c1c-97e2cf4dcc76.png)

	（2）双击打开JRE安装程序，安装Java Runtime Environment（JRE）;
	![image](https://user-images.githubusercontent.com/81380030/194013664-f6a066ab-3a90-442b-9016-b8607f371f1b.png)

	（3）将MyFileFran.jar复制到计算机桌面，打开方式选择Java(TM) Platform SE binary；
  
二、	程序开发平台
1. 代码行数：约650行
2. 开发环境：IntelliJ 2021.2 + JDK 17, SQLite 3.32

三、	程序功能说明以及使用方法
1. 程序功能：基于百度翻译提供的API接口，支持用户将后缀为: doc、docx、xls、xlsx、ppt、pptx、xml、html、htm、txt、pdf的文件在线翻译为中文、英文、韩语、日语，文件大小限制为50M。
2. 使用方法：

	（1）确保网路连接畅通；
	
	（2）打开MyFileTran.jar；
	
	![image](https://user-images.githubusercontent.com/81380030/194013694-2edc9828-a778-4aa7-960a-1c8756c75645.png)

	（3）点击“注册”，选择标准版，在开通其他服务中选择文档翻译；
	
	![image](https://user-images.githubusercontent.com/81380030/194013730-bd53586d-c4ec-444e-93e6-4a0de85d1797.png)
	![image](https://user-images.githubusercontent.com/81380030/194013750-5a63bcc4-61e1-42b7-862e-f1a7e5581a06.png)

	（4）在APP ID和密钥处输入获得的申请信息，点击登录；
	
        （5）输入文件路径；
	例如：C:\Users\Administrator\Desktop\test.docx，在源语言中输入待翻译的语言，在目标语言中输入要翻译成的语言。输入示例：zh（中文）、en（英文）、jp（日语）、kor（韩	 语）、auto（自动，目标语言不支持自动）；
	
 	 ![image](https://user-images.githubusercontent.com/81380030/194013782-32601916-a396-40cd-b9b2-18908bd90dc3.png)

        （6）提示翻译成功，前往http://api.fanyi.baidu.com/api/trans/product/desktop?req=doc 查看翻译结果；
	
	  ![image](https://user-images.githubusercontent.com/81380030/194013850-518a4400-62d6-4a1d-a7df-c3cb84bedcfe.png)

	（7）如果提示翻译失败，则按照提示检查并修改配置；
	  ![image](https://user-images.githubusercontent.com/81380030/194013920-7fcc6e7e-6ebe-49e8-a339-21b55a628a4b.png)


四、      逻辑示意图
![image](https://user-images.githubusercontent.com/81380030/194014505-5999a1a2-8dd5-44ce-addd-f8f86c293cf7.png)


四、	开发日志
2021年11月28日 文档翻译器alpha0.01：实现了统计校验功能，服务器端能识别客户端的APPID以及密钥；

2021年11月30日 文档翻译器alpha0.02：根据百度翻译提供的demo，实现了文档的mp5加密；

2021年12月1日 文档翻译器alpha0.03：接入了翻译服务，可以在主页查看翻译结果了！

2021年12月3日 文档翻译器beta1.01：重新整理了工程代码，可维护性提升了；

2021年12月4日 文档翻译器beta1.01.1：加入了Const类储存APPID、密钥等参数，增加程序健壮性；

2021年12月5日 文档翻译器beta1.02：重大修改，APPID不是通用的，用户需要自己申请，取消了Const保护（但Const类被保留），用户可以自行修改APPID，密钥以及文件路径等参数；

2021年12月6日 文档翻译器beta1.03：利用java swing实现可视化；

2021年12月7日 文档翻译器beta1.04：用户可以自行选择翻译语言，将输入APPID和密钥的界面与参数输入界面分开，加入了结果提示；

2021年12月8日 文档翻译器beta1.05：加入Internet类，用户可以点击注册跳转到主页；

2021年12月8日 文档翻译器release2.01打包发布； 

