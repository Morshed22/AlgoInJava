package HuffmanCoding;

public class HuffmanNode extends HuffmanTree{
    private HuffmanTree leftSubtree;
    private HuffmanTree rightSubTree;

    public HuffmanNode(  HuffmanTree leftSubtree,  HuffmanTree rightSubTree) {
        super(leftSubtree.getFrequency()+rightSubTree.getFrequency());
        this.leftSubtree = leftSubtree;
        this.rightSubTree = rightSubTree;
    }

    public HuffmanTree getLeftSubtree() {
        return leftSubtree;
    }

    public void setLeftSubtree(HuffmanTree leftSubtree) {
        this.leftSubtree = leftSubtree;
    }

    public HuffmanTree getRightSubTree() {
        return rightSubTree;
    }

    public void setRightSubTree(HuffmanTree rightSubTree) {
        this.rightSubTree = rightSubTree;
    }
}
