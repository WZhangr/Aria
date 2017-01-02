# Aria
![图标](https://github.com/AriaLyy/DownloadUtil/blob/v_2.0/app/src/main/res/mipmap-hdpi/ic_launcher.png)</br>
Aria，致力于让下载傻瓜化</br>
+ Aria有以下特点：
 - 简单
 - 可自定义是否使用广播
 - 支持多线程、多任务下载
 - 支持任务自动切换
 - 支持下载速度直接获取

[Aria怎样使用？](#使用)

如果你觉得Aria对你有帮助，您的star和issues将是对我最大支持.`^_^`

## 下载
[![Download](https://api.bintray.com/packages/arialyy/maven/Aria/images/download.svg)](https://bintray.com/arialyy/maven/Aria/_latestVersion)</br>
```java
compile 'com.arialyy.aria:Aria:2.3.3'
```



## 示例
![多任务下载](https://github.com/AriaLyy/DownloadUtil/blob/v_2.0/img/download_img.gif)
![单任务下载](https://github.com/AriaLyy/DownloadUtil/blob/master/img/11.gif "")

## 性能展示
![性能展示](https://github.com/AriaLyy/DownloadUtil/blob/v_2.0/img/performance.png)

***
## 使用
### 一、只需要以下参数，你便能很简单的使用Aria下载文件了
```java
  Aria.whit(this)
        .load(DOWNLOAD_URL)		//下载地址，必填
        .setDownloadPath(Environment.getExternalStorageDirectory().getPath() + "/test.apk")	//文件保存路径，必填
        .setDownloadName("test.apk")	//文件名，必填
        .start();
```
### 二、为了能接收到Aria传递的数据，你需要把你的Activity或fragment注册到Aria管理器中，注册的方式很简单，在onResume
```java
@Override protected void onResume() {
    super.onResume();
    Aria.whit(this).addSchedulerListener(new MySchedulerListener());
  }
```
### 三、通过下载链接，你还能使用Aria执行很多操作，如：
- 添加任务（不进行下载）

  ```java
  Aria.whit(this).load(DOWNLOAD_URL)
    .setDownloadPath(Environment.getExternalStorageDirectory().getPath() + "/test.apk")	//文件保存路径，必填
    .setDownloadName("test.apk")	//文件名，必填
    .add();
	```
- 启动下载

  ```java
  Aria.whit(this).load(DOWNLOAD_URL).start();
  ```
- 暂停下载

  ```java
  Aria.whit(this).load(DOWNLOAD_URL).stop();
  ```
- 恢复下载

  ```java
  Aria.whit(this).load(DOWNLOAD_URL).resume();
  ```
- 取消下载

  ```java
  Aria.whit(this).load(DOWNLOAD_URL).cancel();
  ```
- 获取当前下载进度

  ```java
  Aria.whit(this).load(DOWNLOAD_URL).getCurrentProgress();
  ```
- 获取文件大小

  ```java
  Aria.whit(this).load(DOWNLOAD_URL).getFileSize();
  ```

### 四、关于Aria，你还需要知道的一些东西
- 设置下载任务数，Aria默认下载任务为**2**

  ```java
  Aria.get(getContext()).setMaxDownloadNum(num);
  ```
- 停止所有下载

  ```java
  Aria.get(this).stopAllTask();
  ```
- 设置失败重试次数，从事次数不能少于 1

  ```java
  Aria.get(this).setReTryNum(10);
  ```
- 设置失败重试间隔，重试间隔不能小于 5000ms

  ```java
  Aria.get(this).setReTryInterval(5000);
  ```
- 设置是否打开广播，如果你需要在Service后台获取下载完成情况，那么你需要打开Aria广播，[Aria广播配置](https://github.com/AriaLyy/Aria/blob/v_2.0/BroadCast.md)

  ```java
  Aria.get(this).openBroadcast(true);
  ```

***
## 开发日志
 + v_2.3.3
  - 添加断点支持
  - 修改下载逻辑，让使用更加简单
  - 修复一个内存泄露的bug
 + v_2.3.1 重命名为Aria，下载流程简化
 + v_2.1.1 增加，选择最大下载任务数接口
 + v_2.1.0 修复大量bug

License
-------

    Copyright 2016 AriaLyy(https://github.com/AriaLyy/Aria)

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
