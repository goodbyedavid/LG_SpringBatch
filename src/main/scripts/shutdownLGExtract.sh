#kill PID_TO_KILL
echo "shutting down LGExtract applications"
ps -ef | grep LGExtract.jar | grep -v grep | awk '{print $2}' | xargs kill -9
echo "removing LGExtract pid file.."
rm $ROVI_BASE/extracts/lgExtract/logs/LGExtract.pid

