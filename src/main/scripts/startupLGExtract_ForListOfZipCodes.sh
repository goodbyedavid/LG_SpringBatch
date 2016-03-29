#startup script
#is rovi base set?
#is it oracle java?
#is java home set?
export JMX_OPTS="-Djava.rmi.server.hostname=10.151.66.6 -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=7004 -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl.need.client.auth=false"

export LOGBACK_OPTS="-Dlogback.configurationFile=/opt/rovi_base/conf/lgExtract/logback.xml"
export CLASSPATH=$ROVI_BASE/LGExtract/app:$ROVI_BASE/LGExtract/app/lib
export DELAYTIMEINMINS=$1
echo "CLASSPATH:"
echo $CLASSPATH
echo "JMX OPTS"
echo $JMX_OPTS
echo "LOG BACK OPTS"
echo $LOGBACK_OPTS


# check for the java version currently install
JAVA_VER=`java -version 2>&1| awk 'NR==1{ gsub(/"/,"");print $3}'`
if [[ $JAVA_VER > "1.7" ]]; then
    echo version is higher than 1.7, you are good.
else
    echo version is lower than 1.7, must upgrade to 1.7 for project to work
    return 1
fi

if [ $DELAYTIMEINMINS ];
then
	echo "Delay Time is provided as input. So extract will start in" $DELAYTIMEINMINS "mins"
else
	DELAYTIMEINMINS=1
	echo "No input provided. So extract will start in" $DELAYTIMEINMINS "mins"
fi

#check if pid file exists: if it does, kill process and start new one
if ps ax | grep -v grep | grep LGExtract.jar > /dev/null
then
   echo "service is already running..."
   return 0
else
	echo -n "Please enter list of Zipcodes to run seperated by Pipe (|) "
	read zipCodesList
    java $JMX_OPTS $LOGBACK_OPTS -jar "$ROVI_BASE/LGExtract/app/LGExtract.jar" $DELAYTIMEINMINS $zipCodesList > $ROVI_BASE/extracts/lgExtract/logs/LGExtract.out 2>&1 &
    echo $! "PID" >$ROVI_BASE/extracts/lgExtract/logs/LGExtract.pid
fi

