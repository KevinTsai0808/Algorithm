
# Insertion sort：O(n<sup>2</sup>)
>將原始資料，也就是input中的每一筆未排序資料加入已排序好的資料中，接著和前面的資料做比較並插入合適的位置。

- Pseudocode:

![8_a](https://user-images.githubusercontent.com/103521272/163130955-3e006dc0-5c7b-4272-9c26-005bc3a7b826.gif)

+ Python:
 
<img width="500" alt="截圖 2022-04-13 下午4 16 52" src="https://user-images.githubusercontent.com/103521272/163131935-06c0c3ba-424b-4c15-a26e-913097872227.png">
程式碼較為直觀，在 for 迴圈中從 index1 開始取並將 "key" 設為目前的索引值，接著將 “i" 設為 key 的前一個索引以便比較。
在 while 迴圈中開始進行比較，若目前 i 對應的值比 key 大，則 i+1，也就是 key 的位置會宣告成 i 對應的值並且 i 往前一個位置。
迴圈會在 i 對應的值比 key 小時或是 i < 0 時（也就是 key 值為 input 中最小的數）停止。

# Merge sort：O(nlogn)
>利用Divide-and-conquer完成排序，會將input原始資料分割成左半部分和右半部分<br>分割後的兩筆資料再接著往下分割直到資料內剩一個元素，接著只剩一個元素的左半資料和右半資料進行合併<br>合併的過程會藉由比較左半、右半資料內元素來進行排序，最後形成完整的排序資料。

- Pseudocode (Merge) :

<img width="500" alt="Owtfo"  src="https://user-images.githubusercontent.com/103521272/163158082-e47366ad-3624-4729-a3e9-f269dedbc511.png" >

- Pseudocode (Merge sort) :

<img width="500" alt="wk49i" src="https://user-images.githubusercontent.com/103521272/163158251-2cf4fbae-dd29-4f11-8d28-3266af364866.png">

- Python:

<img width="500" alt="截圖 2022-04-16 下午3 59 05" src="https://user-images.githubusercontent.com/103521272/163667230-5735d4df-0525-4df3-949e-f33e19046b24.png">


在 Merge 函數中有四個參數，分別是要做排列的資料（data）、資料最左側索引值（left）、資料最右側索引值（Right）、資料中間索引值（middle），首先建立兩個 list 放置左半以及右半數列，要注意的是這時左半和右半都已是排列好的狀態。

<img width="500" alt="截圖 2022-04-16 下午3 55 06" src="https://user-images.githubusercontent.com/103521272/163667041-9fa86c08-901a-43ad-85ac-057329f55fb5.png">

這邊在 left 跟 right 建立 sentinel 由於 sentinel 是一個比 input 都大的數，因此我宣告他的值為 data 中最大的值加一。<br>

<img width="500" alt="截圖 2022-04-16 下午4 00 23" src="https://user-images.githubusercontent.com/103521272/163667258-5eff205a-a8af-4a69-bebc-bb7ac98f7359.png">

接著將 “i" ＆ "j" 設定成 0，目的是為了從 left 跟 right 最初的位置進行比較，比較小的放入 data 中且i（若 left 較小）或是 j（若 right 較小）加一。

<img width="413" alt="截圖 2022-04-16 下午4 11 50" src="https://user-images.githubusercontent.com/103521272/163667628-3a3b94a0-a184-4b63-bacd-790d88ebba1e.png">

在 Merge sort 函數中有三個參數，分別是要做排列的資料（data）、資料最左側索引值（left）、資料最右側索引值（Right），首先判斷 data 長度是否大於 1 ，接下來進行 Divide ，將 data 左右分割執行 Merge sort 最後將排序好的左半右半數列用 Merge 函數進行 conquer























## Growth of Function
>從上面所介紹的兩個演算法名稱旁邊可以看到 O( )函數，這個函數指的就是時間複雜度（T(n)），也是我們判斷演算法好壞一個重要的依據，除了 O()，我們也會用其他不同函數來表達演算法的時間複雜度，以下一一進行介紹
* __O(g(n)) Asymptotic Upper Bound : 只要我們找得到 c 和 n<sub>0</sub>，使得 n >= n<sub>0</sub> 時，0 <= f(n) <= cg(n)，就可以說f(n) = O(g(n))__

  <img width="672" alt="截圖 2022-04-14 下午3 43 38" src="https://user-images.githubusercontent.com/103521272/163338120-d639ec66-f2a7-4896-8ace-bfa9633908ee.png">
  
    舉例而言，n<sup>2</sup> = O(n<sup>3</sup>) ; n<sup>2</sup> = O(2n<sup>2</sup>)，g(n)就相當於限制了f(n)的上界，用一張圖來呈現會長這樣：

  <img width="472" alt="截圖 2022-04-14 下午4 04 59" src="https://user-images.githubusercontent.com/103521272/163341729-ad15e27d-5ab7-437b-94ba-fae8cd5afaad.png">

***

* __Ω(g(n)) Asymptotic Lower Bound : 只要我們找得到 c 和 n<sub>0</sub>，使得 n >= n<sub>0</sub> 時，0 <= cg(n) <= f(n)，就可以說f(n) = Ω(g(n))__

  <img width="673" alt="截圖 2022-04-14 下午4 09 03" src="https://user-images.githubusercontent.com/103521272/163342795-52f14060-56f7-4625-a3d2-7cf7a5f4d903.png">
  
  舉例而言，n<sup>3</sup> = Ω(n<sup>2</sup>) ; 2n<sup>2</sup> = Ω(n<sup>2</sup>)，g(n)就相當於限制了f(n)的下界，用一張圖來呈現會長這樣：

  <img width="449" alt="截圖 2022-04-14 下午4 20 12" src="https://user-images.githubusercontent.com/103521272/163344234-8bd4cd5c-1186-40d0-8ed4-433bb0f0e68d.png">
  
  從這兩個函數可以看出他們之間存在著對稱關係，也就是Transpose Symmetry，若f(n) = O(g(n))，則g(n) = Ω(f(n))
  
***
  
* __Θ(g(n) Asymptotic Tight Bound : 只要我們找得到 c<sub>1</sub>、c<sub>2</sub> 和 n<sub>0</sub>，使得 n >= n<sub>0</sub> 時，0 <= c<sub>1</sub>g(n) <= f(n) <= c<sub>2</sub>g(n)，就可以說f(n) =  Θ(g(n))__

  <img width="670" alt="截圖 2022-04-14 下午4 38 48" src="https://user-images.githubusercontent.com/103521272/163347561-6f156be3-56e8-4b7e-8a98-c6b648bc0e2b.png">
  
   舉例而言，4n<sup>2</sup> = Θ(n<sup>2</sup>) ; 3n<sup>2</sup> + 2n = Θ(n<sup>2</sup>)，由定義可以知道之所以說Θ( )是tight bound是因為他限制f(n)和g(n)為同個數量級，我們也可以說當n趨近於無限大時，lim f(n)/g(n) = a，a表示一個常數

  <img width="451" alt="截圖 2022-04-14 下午5 02 19" src="https://user-images.githubusercontent.com/103521272/163351752-ab6162ac-fb33-4ddd-8ff0-2ec2f28c836d.png">
  
   從以上可以知道，若f(n) = Θ(g(n)，則g(n) = Θ(f(n)
 




