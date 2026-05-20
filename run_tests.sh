#!/bin/bash

echo "===================================================="
echo "     Java/Maven Continuous Testing Automation       "
echo "===================================================="

FORCE_FAIL="false"
if [ "$1" == "fail" ]; then
    FORCE_FAIL="true"
    echo "STATUS: Running test suite in FAILURE SIMULATION mode..."
else
    echo "STATUS: Running test suite in SUCCESS SIMULATION mode..."
fi

echo ""
echo "Running Maven Tests..."
if [ "$FORCE_FAIL" == "true" ]; then
    mvn test "-Dforce.fail=true"
else
    mvn test
fi

EXIT_CODE=$?
echo ""
echo "===================================================="
if [ $EXIT_CODE -eq 0 ]; then
    echo "[SUCCESS] Continuous Testing Passed Successfully!"
else
    echo "[FAILURE] Continuous Testing Failed! Exit Code: $EXIT_CODE"
fi
echo "===================================================="

exit $EXIT_CODE
