package my.version3;

import java.util.Arrays;

public class myArrayList {
	private Object[] objects = new Object[10];
	private int index = 0; //记录数组的有效元素
	
	public void add(Object am){
		objects[index++] = am;
		if(index == objects.length)
			objects = Arrays.copyOf(objects, objects.length);
	}
	
	public Object getIndex(int index) throws ArrayIndexOutOfBoundsException
	{
		if(index<0 || index > objects.length)
			throw new ArrayIndexOutOfBoundsException();
		return objects[index];
	}
	
	public boolean contains(Object ob){
		for(int i=0;i<index;i++)
		{
			if(ob.equals(objects[i]))
				return true;
		}
		return false;
	}
	
	//迭代器
	public Iterator interator(){
		return new myIterator();
	}
	
	private class myIterator implements Iterator
	{
		private int size = 0;
		
		@Override
		public Object getCurrent() {
			return objects[size];
		}

		@Override
		public void next() {
			size++;
		}

		@Override
		public boolean isDone() {
			return size == index;
		}
		
	}
}
