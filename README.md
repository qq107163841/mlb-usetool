个人开发中一些方便自己使用的类

	allprojects {
		repositories {
			...
			maven { url 'https://www.jitpack.io' }
		}
	}
  
  	dependencies {
  	        //*对应版本号
	        implementation 'com.github.qq107163841:CommonTools:1.*'
	}
