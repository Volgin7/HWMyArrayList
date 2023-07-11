package sky.myarraylist;

import sky.myarraylist.exception.ElementNotFoundException;
import sky.myarraylist.exception.OutOfArrayLimitsException;

import java.security.InvalidParameterException;

public class ArrayList implements StringList {
    private final int MAX_SIZE = 5;
    String[] stringArray;
    int size;
    public ArrayList() {
        this.stringArray  = new String[MAX_SIZE];
        this.size = 0;
    }

    @Override
    public String add(String item) throws OutOfArrayLimitsException, InvalidParameterException {
        if (this.size >= MAX_SIZE) {
            throw new OutOfArrayLimitsException("Out of Array Limits");
        }
        if (item == null) {
            throw new InvalidParameterException("Invalid parameter == null");
        }
        this.stringArray[this.size] = item;
        return this.stringArray[this.size++];
    }
    @Override
    public String add(int index, String item) throws OutOfArrayLimitsException, InvalidParameterException {
        if (this.size >= MAX_SIZE || index > this.size || index < 0 || index >= MAX_SIZE) {
            throw new OutOfArrayLimitsException("Out of Array Limits");
        }
        if (item == null) {
            throw new InvalidParameterException("Invalid parameter == null");
        }
        for (int i = this.size; i > index; i--) {
            this.stringArray[i] = this.stringArray[i-1];
        }
        this.stringArray[index] = item;
        this.size++;
        return this.stringArray[index];
    }

    public String[] allArray() {
        return this.stringArray;
    }
    @Override
    public String set(int index, String item) throws OutOfArrayLimitsException {
        if (index >= this.size || index < 0) {
            throw new OutOfArrayLimitsException("Out of Array Limits");
        }
        if (item == null) {
            throw new InvalidParameterException("Invalid parameter == null");
        }
        this.stringArray[index] = item;
        return this.stringArray[index];
    }

    @Override
    public String remove(String item) throws OutOfArrayLimitsException, ElementNotFoundException {
        int index = this.indexOf(item);
        if(index == -1) {
            throw new ElementNotFoundException("Element Not Found");
        } else {
            this.remove(index);
        }
        return item;
    }

    @Override
    public String remove(int index) throws OutOfArrayLimitsException {
        if (index >= this.size || index < 0) {
            throw new OutOfArrayLimitsException("Out of Array Limits");
        }
        String item = this.stringArray[index];
        for (int i = index; i < this.size - 1; i++) {
            this.stringArray[i] = this.stringArray[i+1];
        }
        this.stringArray[this.size - 1] = null;
        this.size--;
        return item;
    }

    @Override
    public boolean contains(String item) {

        for (int i = 0; i < this.size; i++) {
            if(item.equals(this.stringArray[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < this.size; i++) {
            if (item.equals(this.stringArray[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = this.size -1; i >= 0; i--) {
            if (item.equals(this.stringArray[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) throws OutOfArrayLimitsException {
        if (index >= this.size || index < 0) {
            throw new OutOfArrayLimitsException("Out of Array Limits");
        }
        return this.stringArray[index];
    }

    @Override
    public boolean equals(StringList otherList) throws OutOfArrayLimitsException, InvalidParameterException {
        if(otherList == null) {
            throw new InvalidParameterException("Invalid parameter == null");
        }
        if(this.size != otherList.size()) {
            return false;
        }
        for (int i = 0; i < this.size; i++) {
            if (!otherList.get(i).equals(this.stringArray[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        if(this.size() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < this.size; i++) {
            this.stringArray[i] = null;
        }
        this.size = 0;
    }

    @Override
    public String[] toArray() {
        String [] newArray= new String[MAX_SIZE];
        for (int i = 0; i < this.size; i++) {
            newArray[i] = this.stringArray[i];
        }
        return newArray;
    }
}
