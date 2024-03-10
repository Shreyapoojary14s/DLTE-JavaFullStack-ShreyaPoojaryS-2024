package block.service.task571;



    public interface Activity<T> {

        String createNewData(T object);
        T readData(int accNumber);
        void updateData(int index,T object);
        String deleteData(int index);

}
