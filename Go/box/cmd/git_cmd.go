package cmd

import (
	"box/bin"

	"github.com/spf13/cobra"
)

// Flag
const ADD = "add"
const LIST = "list"
const PUSH = "push"
const OPEN = "open"

var gitCmd = &cobra.Command{
	Use:   "git",
	Short: "Simplify git command",
	Run: func(cmd *cobra.Command, args []string) {
		//添加
		address, _ := cmd.Flags().GetString(ADD)
		if len(address) != 0 {
			bin.AddRepo(address)
			return
		}
		// 列出
		list, _ := cmd.Flags().GetBool(LIST)
		if list {
			bin.ListRepo()
			return
		}
		//打开配置文件
		open, _ := cmd.Flags().GetBool(OPEN)
		if open {
			bin.OpenConfig()
			return
		}
		//推送
		push, _ := cmd.Flags().GetBool(PUSH)
		if push {
			bin.Push()
			return
		}
		//没有参数就显示帮助信息
		cmd.Help()
	},
}

func init() {
	rootCmd.AddCommand(gitCmd)
	gitCmd.Flags().StringP(ADD, ADD[:1], "", "add new git repository")
	gitCmd.Flags().BoolP(PUSH, PUSH[:1], false, "push all git repository")
	gitCmd.Flags().BoolP(LIST, LIST[:1], false, "list all git repository")
	gitCmd.Flags().BoolP(OPEN, OPEN[:1], false, "open config")
}
