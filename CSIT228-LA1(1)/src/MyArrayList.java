public class MyArrayList<E>{

    private int _size;
    private int capacity;
    private E[] array;

    public MyArrayList(){
        _size = 0;
        capacity = 5;
        array = (E[]) new Object[capacity];
    }

    public void add(E num) throws ArrayFullException{
        try {
            array[_size] = num;
            _size++;
        } catch (Exception e){
            throw new ArrayFullException(num);
        }
    }

    public void addAt(E num, int pos) throws  ArrayFullException{
        if (_size == capacity) throw new ArrayFullException(num);
        if (pos > _size + 1 || pos < 1) throw new InvalidPositionException((Integer)_size + 1);



        for (int i = (int)_size; i >= pos; i--){
            array[i] = array[i - 1];
        }

        _size++;
        array[pos - 1] = num;

    }

    public boolean remove (E num){
        for (int i = 0; i < _size; i++){
            if (array[i] == num){
                _size--;
                for (int j = i; j < _size; j++){
                    array[j] = array[j + 1];
                }

                return true;
            }
        }
        return false;
    }

    public E removeAt(int pos){
        if (pos < 1 || pos > _size) throw new InvalidPositionException(_size);

        E toBeRemoved = array[pos - 1];
        _size--;
        for (int i = pos - 1; i < _size; i++){
            array[i] = array[i+1];
        }
        return toBeRemoved;
    }

    public boolean contains(E num){
        for (int i = 0; i < _size; i++){
            if (array[i] == num){
                return true;
            }
        }
        return false;
    }

    public int size(){
        return _size;
    }

    public boolean isEmpty(){
        return _size == 0;
    }

    public E get(int pos){
        if (pos < 1|| pos > _size) throw new InvalidPositionException(_size);

        return array[pos - 1];
    }

    public E set(int pos, E num){
        if (pos < 1|| pos > _size) throw new InvalidPositionException(_size);

        E toBeReplaced = array[pos - 1];

        array[pos - 1] = num;

        return toBeReplaced;
    }

   public <T, U> void print(T x1, U x2){
//        for (int i = 0; i < _size; i++){
//            System.out.println(x1 + " - " + array[i] +  " - " + x2);
//        }
//
//       System.out.println(" ");

        for (E i : array){
            System.out.println(x1 + " - " + i +  " - " + x2);
        }

       System.out.println(" ");
   }



}
