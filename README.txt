Андреј Јосимовски, 225098

Control Flow Graph
![andrejCFG](https://github.com/andrej-josimovski/SI_2024_lab2_225098/assets/164931652/184b739b-fd1c-44f2-ad14-556b573f2c89)

Цикломатска комплексност
- има 10 региони на графот па цикломатската комплексност е 10, а исто така може да се докаже со тоа што има 7 if услови и 2 for циклуси и додаваме + 1, односно 7+2=9+1=10.

Every Branch method
1. input: allItems = null, payment = 100
output: Исклучок RuntimeException со порака "allItems list can't be null!"
desc: Проверка на гранката каде allItems е null.

2. input: allItems = new ArrayList<>(), payment = 100
output: true
desc: Проверка на празен список на предмети.

3. input: allItems = [нов Item(null, "123456", 100, 0)], payment = 100
output: true
desc: Проверка кога item.getName() е null.

4.input: allItems = [нов Item("", "123456", 100, 0)], payment = 100
output: true
desc: Проверка кога item.getName().length() == 0.

5.input: allItems = [нов Item("item", null, 100, 0)], payment = 100
output: Исклучок RuntimeException со порака "No barcode!"
desc: Проверка на гранката каде item.getBarcode() == null.

6.input: allItems = [нов Item("item", "12345A", 100, 0)], payment = 100
output: Исклучок RuntimeException со порака "Invalid character in item barcode!"
desc: Проверка на гранката каде баркодот содржи невалиден карактер.

7.input: allItems = [нов Item("item", "123456", 100, 0.1f)], payment = 10
output: false
desc: Проверка на гранката каде item.getDiscount() > 0.

8.input: allItems = [нов Item("item", "123456", 100, 0)], payment = 100
output: true
desc: Проверка на гранката каде item.getDiscount() == 0.

9.input: allItems = [нов Item("item", "012345", 350, 0.1f)], payment = 300
output: false
desc: Проверка на гранката каде item.getPrice() > 300, item.getDiscount() > 0, и item.getBarcode().charAt(0) == '0.

10.input: allItems = [нов Item("item", "123456", 100, 0)], payment = 100
output: true
desc: Проверка на гранката каде sum <= payment.

11.input: allItems = [нов Item("item", "123456", 150, 0)], payment = 100
output: false
desc: Проверка на гранката каде sum > payment.
