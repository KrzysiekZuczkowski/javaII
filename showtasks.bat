call runcrud.bat
if "%ERRORLEVEL%"=="0" goto startchrome
echo.
echo runcrud has errors – breaking work
goto fail

:startchrome
start "C:\Program Files\Google\Chrome\Application\chrome.exe" http://localhost:8080/crud/v1/tasks
if "%ERRORLEVEL%"=="0" goto end
echo.
echo chrome didn't started
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.