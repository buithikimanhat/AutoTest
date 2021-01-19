# AutoTest
#Hướng dẫn cài đặt 
Bước 1 - Cài đặt eclipse để có thể thực hiện chạy project
  link download eclipse :  https://www.eclipse.org/downloads/
Bước 2 - Cài đặt Maven cho Eclipse để có thể import 1 Maven project 
  Vào Eclipse > chọn option Help > chọn Install new software
  Chọn Add > Sau đó nhập Name=" m2e" và Location= "http://download.eclipse.org/technology/m2e/releases" > Hoàn thành các bước cài đặt 
Bước 3 - Cài đặt Cucumber cho Eclipse
  Tương tự như cài đặt maven ta thực hiện cài đặt Cucumber cho Eclipse bằng cách thay thao tác nhập Name="Cucumber" 
  và Location=" http://cucumber.github.com/cucumber-eclipse/update-site"
Bước 4 - Thực hiện tạo 1 maven project 
Bước 5 - Add thư viện Junit5 vào project
Bước 6 - Thực hiện thêm các thư viện selenium, gherkin,... vào file pom.xml như sau:
```<dependencies>
		<dependency>
            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>3.3.0</version>
        </dependency>
        <dependency>
            <groupId>xml-apis</groupId>
            <artifactId>xml-apis</artifactId>
            <version>1.4.01</version>
        </dependency>
		<dependency>
			<groupId>com.jayway.restassured</groupId>
			<artifactId>rest-assured</artifactId>
			<version>2.9.0</version>
		</dependency>
		<dependency>
			<groupId>info.cukes</groupId>
			<artifactId>cucumber-core</artifactId>
			<version>1.2.5</version>
		</dependency>
		<dependency>
			<groupId>info.cukes</groupId>
			<artifactId>cucumber-java</artifactId>
			<version>1.2.5</version>
		</dependency>
		<dependency>
			<groupId>info.cukes</groupId>
			<artifactId>cucumber-junit</artifactId>
			<version>1.2.5</version>
		</dependency>
		<dependency>
			<groupId>info.cukes</groupId>
			<artifactId>cucumber-jvm-deps</artifactId>
			<version>1.0.5</version>
		</dependency>
		<dependency>
			<groupId>info.cukes</groupId>
			<artifactId>gherkin</artifactId>
			<version>2.12.2</version>
		</dependency>
		<dependency>
			<groupId>org.hamcrest</groupId>
			<artifactId>hamcrest-all</artifactId>
			<version>1.3</version>
		</dependency>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.12</version>
		</dependency>
		<dependency>
			<groupId>info.cukes</groupId>
			<artifactId>cucumber-picocontainer</artifactId>
			<version>1.2.5</version>
		</dependency>
		<dependency>
			<groupId>info.cukes</groupId>
			<artifactId>cucumber-html</artifactId>
			<version>0.2.6</version>
		</dependency>
		<dependency>
			<groupId>org.seleniumhq.selenium</groupId>
			<artifactId>selenium-chrome-driver</artifactId>
			<version>2.45.0</version>
		</dependency>
		<dependency>
    <groupId>com.github.detro.ghostdriver</groupId>
    <artifactId>phantomjsdriver</artifactId>
    <version>1.1.0</version>
    </dependency>
		<dependency>
			<groupId>org.seleniumhq.selenium</groupId>
			<artifactId>selenium-support</artifactId>
			<version>2.45.0</version>
		</dependency>
		<dependency>
			<groupId>commons-io</groupId>
			<artifactId>commons-io</artifactId>
			<version>2.5</version>
		</dependency>
		<dependency>
	    	<groupId>org.apache.poi</groupId>
	    	<artifactId>poi-ooxml</artifactId>
	    	<version>3.10-FINAL</version>
    	</dependency>
		<dependency>
			<groupId>org.seleniumhq.selenium</groupId>
			<artifactId>selenium-java</artifactId>
			<version>2.45.0</version>
		</dependency>
		<dependency>
			<groupId>org.seleniumhq.selenium</groupId>
			<artifactId>selenium-firefox-driver</artifactId>
			<version>2.45.0</version>
		</dependency>
	</dependencies>```
  Bước 7 - thực hiện tạo các file code tương ứng cho project 
  Bước 8 - Chạy chương trình 
