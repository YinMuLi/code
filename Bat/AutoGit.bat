@echo off
setlocal enabledelayedexpansion
@REM 推送地址数组,修改此数组的同时需要修改下面FOR循环的
set repos[0]="C:\Users\Administrator\Documents\My Games\Terraria\tModLoader\ModSources\Branch"
set repos[1]=D:\Work\School
set repos[2]=D:\Work\Code
@REM 推送的信息
set message=%date% %time:~0,5% AUTO
@REM 遍历数组
FOR /L %%i IN (0, 1, 2) DO (
    @REM 切换到指定目录
    cd !repos[%%i]!
    @REM 设置状态变量为空
    set status=
    @REM 查看此仓库是否有修改
    FOR /F "delims=" %%a IN ('git status -s') DO (
        set status=%%a
    )
    @REM 推送此仓库
    IF DEFINED status (
            git add .
            git commit -m"!message!"
            git push
        )
)
pause
