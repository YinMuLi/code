const p = new Promise((resolve, reject) => {
  var num = Math.ceil(Math.random() * 20); //生成1-10的随机数
  console.log("随机数生成的值：", num);
  if (num <= 10) {
    resolve(num);
  } else {
    reject("数字太于10了即将执行失败回调");
  }
});
p.then(
  (res) => {
    console.log("OK");
  },
  (error) => {
    console.log("error");
  }
);
