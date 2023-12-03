package bin

import (
	"fmt"
	"os"
	"path"

	"github.com/spf13/viper"
)

// 配置文件路径
var configFile = path.Join(os.Getenv("USERPROFILE"), "box.yaml")

func InitConfig() {
	// 设置配置文件路径
	viper.AddConfigPath(os.Getenv("USERPROFILE"))
	// viper.AddConfigPath("./")
	// 指定配置文件名称
	viper.SetConfigName("box.yaml")
	// 设置配置文件类型
	viper.SetConfigType("yaml")
	// 读取配置文件
	err := viper.ReadInConfig()
	if err != nil {
		if _, ok := err.(viper.ConfigFileNotFoundError); ok {
			// 找不到配置文件，创建配置文件
			os.Create(configFile)
		} else {
			fmt.Println("配置文件出错")
		}
	}
}
func OpenConfig() {
	ExecShell("start box.yaml", os.Getenv("USERPROFILE"))
}
func ConfigSet(key string, value interface{}) {
	viper.Set(key, value)
	viper.WriteConfig()
}
