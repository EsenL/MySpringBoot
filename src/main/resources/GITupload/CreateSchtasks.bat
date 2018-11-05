%创建计划任务，每天执行一次%
schtasks /create /tn GITPush /tr E:\GITWorkspace\循环上传GIT项目\上传GIT项目.bat /sc DAILY /mo 1


