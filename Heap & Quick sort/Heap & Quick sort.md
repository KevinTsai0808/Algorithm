
# Heap sort：O(nlogn)
>先將原始資料透過遞迴比較方法形成樹的結構，也就是達成 Heap ，這個樹的特性是父節點會大於（小於）子節點<br>接著透過交換方法取得每一次迭代中樹的最大值（最小值）並放入陣列，最後得到完整排序資料

- Pseudocode：（Max-Heapify） <br>
建立 Max-Heap 有兩個重點(這邊以由小到大的排列為例），首先是 Max-Heapify ，這個方法會定義目前元素在樹中的位置。
<img width="500" alt="截圖 2022-05-09 下午5 45 18" src="https://user-images.githubusercontent.com/103521272/167384664-93ee0cc7-e3a7-4e2c-b5c3-2e2e8b396778.png">



+ Java：（Max-Heapify）
<img width="500" alt="截圖 2022-05-09 下午5 56 50" src="https://user-images.githubusercontent.com/103521272/167386625-1c2e9be9-0404-46e9-bf6d-e33f677165c5.png">
Max-Heapify 的參數分別是一個陣列以及陣列的 index ，首先存取 i 的子節點位置，接著定義樹的大小為 heap-size，也就是樹的節點數量，由於後面執行 sort 的時候 heap-size 並不會總是等於陣列長度，因此只有當 heap-size 尚未被前面敘述定義時才會等於陣列長度。<br><br>

<img width="426" alt="截圖 2022-05-09 下午6 04 22" src="https://user-images.githubusercontent.com/103521272/167388016-cb5f1558-9572-4583-935d-272f98181ac6.png">
然後是父節點和子節點之間的比較，首先比較左邊子節點和父節點，較大的再和右邊子節點比較。<br><br>

<img width="337" alt="截圖 2022-05-09 下午6 11 34" src="https://user-images.githubusercontent.com/103521272/167389293-fbc6b6cf-e782-4210-b57c-efb2dcbd1099.png">
最後若目前的父節點不是三個中最大的，那麼就將最大的那個節點和父節點交換，交換以後原本的父節點再繼續和最大的那個節點的子節點進行比較，也就是重新執行 Max-Heap 。<br><br>
執行之後原本的父節點就會被排列在樹中適當的位置，也就是大於等於底下兩個分支並且小於目前位置的父節點。

***

- Pseudocode：（Build-Max-Heap） <br>
<img width="500" alt="截圖 2022-05-10 上午12 14 07" src="https://user-images.githubusercontent.com/103521272/167452611-1d239c8f-1c45-40a9-9c59-38bc43a19f06.png">

第二個重點是該從做幾次 Max-Heapify 來達到 Max-Heap，因此使用 Build-Max-Heap 。

+ Java：（Build-Max-Heap）<br>
<img width="407" alt="截圖 2022-05-10 上午12 44 44" src="https://user-images.githubusercontent.com/103521272/167457794-2f118efc-1bad-4514-a9ef-fb7c101cdd08.png">

同樣的只有當 heap-size 尚未被前面敘述定義時才會等於陣列長度。<br>
然後從最後一個父節點開始往上做 Max-Heapify，之所以由下往上是因為只要做完一次 Max-Heapify 就可以保證該節點以下都是 Max-Heap 。<br>

當 Build-Max-Heap 執行完後，每一個父節點都會比子節點還要大，然而這個條件並不足以完成排序，像是[16, 3, 6, 1, 2, 5]，就是符合樹的條件但沒有排序完成的例子，因此我們要進行下一個步驟。

***



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
























 





