// 声明变量
let a: number;
a = 10;
let d = 20;
let b: boolean = false;
// 联合类型，很少使用。
let c: 20; //c的值只能是20
c = 20;
let z: "male" | "fmale";
z = "fmale";
z = "male";
let o: number | boolean;
o = 25;
o = false;
//any:任意类型,意味着关闭了TS类型检测
let saber: any; //显式any
let archer; //隐式any
saber = 1;
saber = "saber";
//any类型可以赋值给任意变量
let lancer: string;
lancer = saber;
//unknown是类型安全的any，不能直接赋值给其它变量
let apple: unknown;
if (typeof apple == "string") {
  lancer = apple;
}
lancer = apple as string;
lancer = <string>apple;
// 函数
function sum(a: number, b: number): number {
  return a + b;
}
function hello(a: number): string | number {
  if (a > 1) {
    return "string";
  }
  return 1;
}
function no(): void {}
//函数类型变量
let del: (a: number, b: number) => number;
del = function (a, b): number {
  return a - b;
};
//对象
//?可选属性
let service: { name: string; age?: 10 | 20 };
service = { name: "大圣", age: 10 };
service = { name: "大圣" };
//[propName: string]: any->任意类型属性。
//js中属性名是string类型的。
let bot: { name: string; [propName: string]: any };
bot = { name: "八戒", age: 20, sex: "男" };
//数组
let users: string[];
users = ["张三", "李四", "王五"];
let staff: Array<string>;
staff = ["赵六", "天上天下"];
//元祖：固定长度的数组
let employee: [string, number];
employee = ["五条悟", 123456];
//枚举
enum Gender {
  Male,
  Female,
}
//类型的别名
type MyType = number | string | boolean;
let employ: MyType;
employ = 20;
export {};
