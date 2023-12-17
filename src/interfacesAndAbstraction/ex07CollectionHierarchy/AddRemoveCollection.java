package interfacesAndAbstraction.ex07CollectionHierarchy;

public class AddRemoveCollection extends Collection implements AddRemovable {

    @Override
    public int add(String item) {
        super.getItems().add(0, item);
        return 0;
    }

    @Override
    public String remove() {
        return super.getItems().remove(super.getItems().size() - 1);
    }
}
