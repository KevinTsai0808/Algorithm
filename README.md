# Algorithm
>在這邊會簡單介紹不同的演算法並利用Python實作，主要就是紀錄上課所學的內容
>演算法就是將 input 透過一系列明確定義的計算步驟產生 output，input可能是空集合或是數值的集合，一個演算法的好壞取決於時間複雜度以及空間複雜度。

時間複雜度：在電腦上執行計算演算法的時間

空間複雜度：在電腦上執行計算演算法所佔用的記憶體資源

## Insertion sort：O(n<sup>2</sup>)
>將原始資料，也就是input中的每一筆未排序資料加入已排序好的資料中，接著和前面的資料做比較並插入合適的位置

- Pseudocode:

![8_a](https://user-images.githubusercontent.com/103521272/163130955-3e006dc0-5c7b-4272-9c26-005bc3a7b826.gif)

+ Python:

<img width="638" alt="截圖 2022-04-13 下午4 16 52" src="https://user-images.githubusercontent.com/103521272/163131935-06c0c3ba-424b-4c15-a26e-913097872227.png">

## Merge sort：O(nlogn)
>利用Divide-and-conquer完成排序，會將input原始資料分割成左半部分和右半部分，分割後的兩筆資料再接著往下分割直到資料內剩一個元素，接著只剩一個元素的左半資料和右半資料進行合併，合併的過程會藉由比較左半、右半資料內元素來進行排序，最後形成完整的排序資料

- Pseudocode (Merge) :

<img width="336" alt="Owtfo" src="https://user-images.githubusercontent.com/103521272/163158082-e47366ad-3624-4729-a3e9-f269dedbc511.png">

- Pseudocode (Merge sort) :

<img width="225" alt="wk49i" src="https://user-images.githubusercontent.com/103521272/163158251-2cf4fbae-dd29-4f11-8d28-3266af364866.png">

- Python:

<img width="473" alt="截圖 2022-04-13 下午6 05 26" src="https://user-images.githubusercontent.com/103521272/163158307-0d9bf62e-38d0-4463-8c46-b9234dbc885d.png">

## Growth of Function
>從上面所介紹的兩個演算法名稱旁邊可以看到 O( )函數，這個函數指的就是時間複雜度（T(n)），也是我們判斷演算法好壞一個重要的依據，除了 O()，我們也會用其他不同函數來表達演算法的時間複雜度，以下一一進行介紹
* O(g(n)) Asymptotic Upper Bound : 只要我們找得到 c 和 n<sub>0</sub>，使得 n >= n<sub>0</sub> 時，0 <= f(n) <= cg(n)，就可以說f(n) = O(g(n))

  <img width="672" alt="截圖 2022-04-14 下午3 43 38" src="https://user-images.githubusercontent.com/103521272/163338120-d639ec66-f2a7-4896-8ace-bfa9633908ee.png">
  
    舉例而言，n<sup>2</sup> = O(n<sup>3</sup>) ; n<sup>2</sup> = O(2n<sup>2</sup>)，g(n)就相當於限制了f(n)的上界，用一張圖來呈現會長這樣：

  <img width="472" alt="截圖 2022-04-14 下午4 04 59" src="https://user-images.githubusercontent.com/103521272/163341729-ad15e27d-5ab7-437b-94ba-fae8cd5afaad.png">
  
* Ω(g(n)) Asymptotic Lower Bound : 只要我們找得到 c 和 n<sub>0</sub>，使得 n >= n<sub>0</sub> 時，0 <= cg(n) <= f(n)，就可以說f(n) = Ω(g(n))

  <img width="673" alt="截圖 2022-04-14 下午4 09 03" src="https://user-images.githubusercontent.com/103521272/163342795-52f14060-56f7-4625-a3d2-7cf7a5f4d903.png">
  
  舉例而言，n<sup>3</sup> = Ω(n<sup>2</sup>) ; 2n<sup>2</sup> = Ω(n<sup>2</sup>)，g(n)就相當於限制了f(n)的下界，用一張圖來呈現會長這樣：

  <img width="449" alt="截圖 2022-04-14 下午4 20 12" src="https://user-images.githubusercontent.com/103521272/163344234-8bd4cd5c-1186-40d0-8ed4-433bb0f0e68d.png">
  
  從這兩個函數可以看出他們之間存在著對稱關係，也就是Transpose Symmetry，若f(n) = O(g(n))，則g(n) = Ω(f(n))
  
* Θ(g(n) Asymptotic Tight Bound : 只要我們找得到 c<sub>1</sub>、<sub>2</sub> 和 n<sub>0</sub>，使得 n >= n<sub>0</sub> 時，0 <= c<sub>1</sub>g(n) <= f(n) <= c<sub>2</sub>g(n)，就可以說f(n) =  Θ(g(n))






