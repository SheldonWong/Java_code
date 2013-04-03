package c08.dataStructure;

public class IntegerCompare implements Compare{

	@Override
	public boolean lessThan(Object lhs, Object rhs) {
		return (Integer)lhs<(Integer)rhs;

	}

	@Override
	public boolean lessThanOrEqu(Object lhs, Object rhs) {
		return (Integer)lhs<=(Integer)rhs;
	}

}
