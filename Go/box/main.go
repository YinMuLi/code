package main

import (
	"box/bin"
	"box/cmd"
)

func main() {
	// 加载配置文件
	bin.InitConfig()
	cmd.Execute()
}
