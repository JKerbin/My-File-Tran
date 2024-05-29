# 文档翻译器

使用java编写的基于百度api的文档翻译器

## 运行环境

- JDK17

## 功能说明

- 基于百度翻译提供的API接口；
- 支持用户将后缀为: doc、docx、xls、xlsx、ppt、pptx、xml、html、htm、txt、pdf的文件在线翻译为中文、英文、韩语、日语，文件大小限制为50M。

## 使用方法：

- 确保网路连接畅通；
	
- 打开MyFileTran.jar；
	
![image](https://user-images.githubusercontent.com/81380030/194013694-2edc9828-a778-4aa7-960a-1c8756c75645.png)

- 点击“注册”，选择标准版，在开通其他服务中选择文档翻译；
	
![image](https://user-images.githubusercontent.com/81380030/194013730-bd53586d-c4ec-444e-93e6-4a0de85d1797.png)
![image](https://user-images.githubusercontent.com/81380030/194013750-5a63bcc4-61e1-42b7-862e-f1a7e5581a06.png)

- 在APP ID和密钥处输入获得的申请信息，点击登录，然后输入文件路径，点击确认；如果提示翻译失败，则按照提示检查并修改配置；
``` 
# 例如
C:\Users\Administrator\Desktop\test.docx
# 在源语言中输入待翻译的语言，在目标语言中输入要翻译成的语言
zh（中文）en（英文）jp（日语）kor（韩语）auto（自动，目标语言不支持自动）；
```	
![image](https://user-images.githubusercontent.com/81380030/194013782-32601916-a396-40cd-b9b2-18908bd90dc3.png)
![image](https://user-images.githubusercontent.com/81380030/194013850-518a4400-62d6-4a1d-a7df-c3cb84bedcfe.png)
![image](https://user-images.githubusercontent.com/81380030/194013920-7fcc6e7e-6ebe-49e8-a339-21b55a628a4b.png)

