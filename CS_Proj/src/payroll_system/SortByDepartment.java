package payroll_system;

import java.util.LinkedList;

public class SortByDepartment {

	public void quickSort(LinkedList<list_model> list,int swtch) {
	    if (list == null || list.size() <= 1){
	      return;
	    }
	    quick(list, 0, list.size(),swtch);
	  }
	  
	  public String findKthLargest(LinkedList<list_model> list, int k,int swtch) {
	    // f([11,12,13], 1) => 13
	    // f([11,12,13], 2) => 12
	    assert(1 <= k && k <= list.size());
	    int targetIdx = list.size() - k;
	    int start = 0;
	    int end = list.size();
	    while (start + 1 < end) {
	      int i = partition(list, start, end,swtch);
	      if (i == targetIdx) {
	        return list.get(i).getDepartment();
	      } else if (i < targetIdx) {
	        start = i + 1;
	      } else {
	        end = i;
	      }
	    }
	    return list.get(start).getDepartment();
	  }

	  private void quick(LinkedList<list_model> list, int start, int end,int swtch){
	    if (start + 1 >= end){
	      return;
	    }
	    int mid = partition(list, start, end,swtch);
	    quick(list, start, mid,swtch);
	    quick(list, mid + 1, end,swtch);
	  }

	  private int partition(LinkedList<list_model> list, int start, int end,int swtch){
	    // start inclusive
	    // end exclusive
	    // return the pivot position

	    if (start + 1 >= end){
	      return start;
	    }

	    String pivot = list.get(start).getDepartment();
	    int i = start;
	    int compare;
	    for (int j = start + 1; j < end; ++j)
	    { 	if(swtch == 1)
    	{
    	int length = list.get(j).getDepartment().length();
    	int pivotl = pivot.length();
    	int min = 0;
    	if(length<=pivotl)
    	{
    		min = length;
    	}
    	else{
    		min = pivotl;
    	}
    	
    	for(int z=0; z<min;z++){
		if (list.get(j).getDepartment().toUpperCase().charAt(z) < pivot.toUpperCase().charAt(z)) {
			i += 1;
			swap(list, i, j);
			break;
		}
		else if(list.get(j).getDepartment().toUpperCase().charAt(z) > pivot.toUpperCase().charAt(z))
		{
			break;
		}
    	}
    	
  }
	else{
		int length = list.get(j).getDepartment().length();
    	int pivotl = pivot.length();
    	int min = 0;
    	if(length<=pivotl)
    	{
    		min = length;
    	}
    	else{
    		min = pivotl;
    	}
    	
    	for(int z=0; z<min;z++){
		if (list.get(j).getDepartment().toUpperCase().charAt(z) > pivot.toUpperCase().charAt(z)) {
			i += 1;
			swap(list, i, j);
			break;
		}
		else if(list.get(j).getDepartment().toUpperCase().charAt(z) < pivot.toUpperCase().charAt(z))
		{
			break;
		}
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