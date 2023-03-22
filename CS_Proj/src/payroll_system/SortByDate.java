package payroll_system;

import java.util.LinkedList;

public class SortByDate {

	//Using quicksort in sorting the list
	
	public void quickSort(LinkedList<list_model> list) {
	    if (list == null || list.size() <= 1){
	      return;
	    }
	    quick(list, 0, list.size());
	  }
	  
	  public int findKthLargest(LinkedList<list_model> list, int k) {
	
	    assert(1 <= k && k <= list.size());
	    int targetIdx = list.size() - k;
	    int start = 0;
	    int end = list.size();
	    while (start + 1 < end) {
	      int i = partition(list, start, end);
	      if (i == targetIdx) {
	        return list.get(i).getpYear();
	      } else if (i < targetIdx) {
	        start = i + 1;
	      } else {
	        end = i;
	      }
	    }
	    return list.get(start).getpYear();
	  }

	  private void quick(LinkedList<list_model> list, int start, int end){
	    if (start + 1 >= end){
	      return;
	    }
	    int mid = partition(list, start, end);
	    quick(list, start, mid);
	    quick(list, mid + 1, end);
	  }

	  private int partition(LinkedList<list_model> list, int start, int end){
	    // start inclusive
	    // end exclusive
	    // return the pivot position

	    if (start + 1 >= end){
	      return start;
	    }

	    int pivot = list.get(start).getpYear();
	    int i = start;
	    for (int j = start + 1; j < end; ++j) {
	    	
	    		if (list.get(j).getpYear() > pivot) {
	    			i += 1;
	    			swap(list, i, j);
	    		}
	    		else if(list.get(j).getpYear() == pivot){
	    		if (list.get(j).getPmonth() > list.get(start).getPmonth()) {
	    			i += 1;
	    			swap(list, i, j);
	    		}
	    		}
	    	
	    }
	    swap(list, start, i);
	    return i;
	  }

	  private void swap(LinkedList<list_model> list, int x, int y){
	    list_model tmp = list.get(x);
	    list.set(x,list.get(y));
	    list.set(y,tmp);
	  }
	
	
}
