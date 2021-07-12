### 命令生成证书：

keytool -genkey -alias 别名  
-storetype 仓库类型 -keyalg 算法 -keysize ⻓长度   -keystore ⽂文件名 -validity 有效期



### 参数说明：

- 仓库类型，JKS、JCEKS、PKCS12 等
- 算法，RSA、DSA 等
- 长度，例如 2048



### 示例：

keytool -genkey -alias springbucks -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore springbucks.p12 -validity 365

输入密钥库口令:  
再次输入新口令:
您的名字与姓氏是什么?

[Unknown]:  Kevin

您的组织单位名称是什么?

[Unknown]:  Home

您的组织名称是什么?

[Unknown]:  Home

您所在的城市或区域名称是什么?

[Unknown]:  Beijing

您所在的省/市/自治区名称是什么?

[Unknown]:  Beijing

该单位的双字母国家/地区代码是什么?

[Unknown]:  CN

CN=Kevin, OU=Home, O=Home, L=Beijing, ST=Beijing, C=CN是否正确?

[否]:  是


