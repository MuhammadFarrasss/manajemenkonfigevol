@echo off
SETLOCAL EnableDelayedExpansion

echo ====================================================
echo      Java/Maven Continuous Testing Automation      
echo ====================================================

:: Check if "fail" was passed as an argument
SET FORCE_FAIL=false
IF "%~1"=="fail" (
    SET FORCE_FAIL=true
    echo STATUS: Running test suite in FAILURE SIMULATION mode...
) ELSE (
    echo STATUS: Running test suite in SUCCESS SIMULATION mode...
)

echo.
echo Running Maven Tests...
IF "!FORCE_FAIL!"=="true" (
    call mvn test "-Dforce.fail=true"
) ELSE (
    call mvn test
)

SET EXIT_CODE=%ERRORLEVEL%
echo.
echo ====================================================
IF %EXIT_CODE% EQU 0 (
    echo [SUCCESS] Continuous Testing Passed Successfully!
) ELSE (
    echo [FAILURE] Continuous Testing Failed! Exit Code: %EXIT_CODE%
)
echo ====================================================

exit /b %EXIT_CODE%
