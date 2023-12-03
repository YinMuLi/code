package bin

import (
	"fmt"
	"os/exec"
	"time"

	"github.com/spf13/viper"
	"golang.org/x/text/encoding/simplifiedchinese"
)

const GIT = "REPO"

// 添加地址
func AddRepo(path string) {
	git := viper.GetStringSlice(GIT)
	ConfigSet(GIT, append(git, path))
}

// 列出所有地址
func ListRepo() {
	git := viper.GetStringSlice(GIT)
	//遍历输出
	for index, value := range git {
		fmt.Printf("[%d] %s\n", index, value)
	}
}

// 推送git会自动安装bash.exe|sh.exe
func Push() {
	git := viper.GetStringSlice(GIT)
	//获取当前日期
	pushTime := time.Now().Format("2006-01-02 15:04")
	for i := 0; i < len(git); i++ {
		path := git[i]
		//查看该路径是否有文件可以提交
		cmd := exec.Command("git", "status", "-s")
		cmd.Dir = path //设置工作路径
		out, _ := cmd.Output()
		if len(out) == 0 {
			continue
		}
		ExecShell("git add .", path)
		ExecShell(fmt.Sprintf("git commit -m'%s (AUTO)'", pushTime), path)
		ExecShell("git push", path)
	}
}

func ExecShell(shell, workDir string) {
	cmd := exec.Command("bash", "-c", shell)
	cmd.Dir = workDir
	out, _ := cmd.CombinedOutput()
	//处理中文乱码
	output, _ := simplifiedchinese.GB18030.NewDecoder().Bytes(out)
	fmt.Print(string(output))
}
