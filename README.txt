打包成可执行jar包（包含依赖的jar）
#run.jar是以前在windows上打好的jar包,放在这里做个比较
=====================================================================
cd /Users/qhli/src/java/javase-core/javase-jar
#手动编译，会在当前目录下生成文件com/qhli/demo/javase/core/jar/Main.class
#mvn clean compile

javac -d . src/main/java/com/qhli/demo/javase/core/jar/Main.java -classpath ./lib/commons-io-1.2.jar:./lib/commons-lang-2.4.jar
java -classpath .:./lib/commons-io-1.2.jar:./lib/commons-lang-2.4.jar com/qhli/demo/javase/core/jar/Main
#打jar包
#jar cvfm run3.jar MANIFEST.MF -C target/classes/ . config/ lib/
#jar cvfm run.jar MANIFEST.MF org lib config
jar -cvfm run2.jar MANIFEST.MF com/ lib/ config/
#查看jar中内容
jar -tvf run2.jar
#运行
java -jar run2.jar
=======================================================================

使用maven来打包
http://www.cnblogs.com/yjmyzz/p/4241528.html

=======================================================================
最后说明：Manifest技巧 
   总是以Manifest-Version属性开头 
   每行最长72个字符，如果超过的话，采用续行 
   确认每行都以回车键结束，否则改行将会被忽略 
   如果Class-Pass中存在路径，使用“/”分隔目录，与平台无关 
   使用空行分隔属性和package属性 
   使用"/"而不是"."来分隔package和class。比如com/example/myapp/ 
   class要发.class结尾，package要以/结尾
=======================================================================

用法：jar {ctxu}[vfm0Mi] [jar-文件] [manifest-文件] [-C 目录] 文件名 ...
选项：
    -c  创建新的存档
    -t  列出存档内容的列表
    -x  展开存档中的命名的（或所有的〕文件
    -u  更新已存在的存档
    -v  生成详细输出到标准输出上
    -f  指定存档文件名
    -m  包含来自标明文件的标明信息
    -0  只存储方式；未用ZIP压缩格式
    -M  不产生所有项的清单（manifest〕文件
    -i  为指定的jar文件产生索引信息
    -C  改变到指定的目录，并且包含下列文件：
如果一个文件名是一个目录，它将被递归处理。
清单（manifest〕文件名和存档文件名都需要被指定，按'm' 和 'f'标志指定的相同顺序。
示例1：将两个class文件存档到一个名为 'classes.jar' 的存档文件中：
       jar cvf classes.jar Foo.class Bar.class
示例2：用一个存在的清单（manifest）文件 'mymanifest' 将 foo/ 目录下的所有
           文件存档到一个名为 'classes.jar' 的存档文件中：
       jar cvfm classes.jar mymanifest -C foo/ .