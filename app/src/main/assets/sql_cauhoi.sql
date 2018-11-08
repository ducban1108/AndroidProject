BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS `cauhoi` (
	`_id`	TEXT,
	`question`	TEXT,
	`ans_a`	TEXT,
	`ans_b`	TEXT,
	`ans_c`	TEXT,
	`ans_d`	TEXT,
	`result`	TEXT,
	`types`	TEXT
);
INSERT INTO `cauhoi` VALUES ('1','Làm gì?
Hai tay bưng lấy khư khư
Bụng thì bảo dạ rằng ư đút vào
Đút vào nó sướng làm sao
Rập lên, rập xuống nó trào nước ra','Ăn mía','Quay tay','Cầm gậy','Nhảy HipHop','A','Hỏi xoáy đáp xoay');
INSERT INTO `cauhoi` VALUES ('2','Là cái gì?
Bốn chân chong chóng
Hai bụng kề nhau
Cắm giữa phao câu
Nghiến đi nghiến lại','Cái cân','Đôi dép','Cái thìa','Cối xay','D','Hỏi xoáy đáp xoay');
INSERT INTO `cauhoi` VALUES ('3','Ô kìa chim cu
Thụt ra thụt vào
Qua cái cửa nhỏ
Đi kèm tiếng kêu','Ấy nhau','Đồng hồ quả lắc có con chim báo
giờ','Liếm nhau','Trái tim','B','Hỏi xoáy đáp xoay');
COMMIT;
