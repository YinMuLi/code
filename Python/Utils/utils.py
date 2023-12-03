import uiautomator2 as u2
import cv2
import time


class Connector:
    def __init__(self):
        # 默认连接的是雷电模拟器
        self.driver = u2.connect("emulator-5554")

    def processImg(self, imgPath):
        # 截屏
        screenImg = self.driver.screenshot(format="opencv")
        # 对图像进行灰度处理
        # screenImg = cv2.cvtColor(screenImg, cv2.COLOR_BGR2GRAY)
        cv2.imwrite("Screen.png", screenImg)
        # 加载模版图片
        template = cv2.imread(imgPath)
        # 获取模版图片的宽高
        width, heigth = template.shape[:2]
        # 将模版图片进行灰度处理
        # template = cv2.cvtColor(template, cv2.COLOR_BGR2GRAY)
        # 进行图片匹配
        result = cv2.matchTemplate(screenImg, template, cv2.TM_CCOEFF_NORMED)
        # 找出最佳匹配结果
        min_val, max_val, min_loc, max_loc = cv2.minMaxLoc(result)
        # 计算中心位置
        center = (max_loc[0]+width/2, max_loc[1]+heigth/2)
        if max_val > 0.7:
            self.matched = True
        else:
            self.matched = False
        self.point = center

    def clickImg(self, imgPath):
        self.processImg(imgPath)
        # if self.matched:
        #     self.driver.click(self.point[0], self.point[1])
        self.driver.click(self.point[0], self.point[1])
        time.sleep(4)
