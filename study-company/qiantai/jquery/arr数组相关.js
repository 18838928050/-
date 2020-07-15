 var arr_vals = ['4','5','6','7','8','9','10','11','12','13','14','15','16','17','18','19','20','21'];
            if (compareTou(arr_vals,relationValue)) {//如果返回true,可以进入if判断
            	
            }


		      //数组循环
		      function compareTou(arr, item) {
		      	for (var i = 0; i < arr.length; i++) {
		      		if (arr[i] == item) {
		      			return true;
		      		}
		      	}
		      	return false;
		      };