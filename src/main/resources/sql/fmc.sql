CREATE TABLESPACE TBS_ORCL_DEMO DATAFILE '查询到的文件地址' size 200M AUTOEXTEND on next 50M MAXSIZE UNLIMITED EXTENT MANAGEMENT LOCAL ;


CREATE TABLESPACE FMC_DATA DATAFILE
  'F:\oracle\fmc\FMC_DATA.DBF' SIZE 300M AUTOEXTEND ON NEXT 10M MAXSIZE UNLIMITED
LOGGING
ONLINE
PERMANENT
EXTENT MANAGEMENT LOCAL AUTOALLOCATE
BLOCKSIZE 8K
SEGMENT SPACE MANAGEMENT AUTO
FLASHBACK ON;



CREATE USER fmc IDENTIFIED BY fmc;

GRANT "CONNECT" TO fmc WITH ADMIN OPTION;
GRANT "RESOURCE" TO fmc WITH ADMIN OPTION;
GRANT "DBA" TO fmc WITH ADMIN OPTION;
GRANT CREATE ANY TABLE TO fmc;

ALTER USER fmc DEFAULT ROLE "CONNECT";
ALTER USER fmc DEFAULT ROLE "RESOURCE";
ALTER USER fmc DEFAULT ROLE "DBA";



mvn install:install-file -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0.1 -Dpackaging=jar -Dfile=D:\ojdbc6.jar


 Non-readable settings D:\apache-maven-3.6.0-bin\apache-maven-3.6.0\bin\..\conf\settings.xml: no more data available - expected end tag </xml> to close start tag <xml> from line 1, parser stopped on END_TAG seen ...</settings>\n... @275:1 @ D:\apache-maven-3.6.0-bin\apache-maven-3.6.0\bin\..\conf\settings.xml