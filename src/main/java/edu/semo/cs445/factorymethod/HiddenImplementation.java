package edu.semo.cs445.factorymethod;

/**
 * Note that this implementation class isn't visible outside the package because
 * it's got no public access modifier. Normally that means you wouldn't be able
 * to use it, but a factory method allows us to make it available elsewhere.
 */
class HiddenImplementation implements DemoInterface {

	/**
	 * This is a package-protected constructor.
	 */
	HiddenImplementation() {

	}

	@Override
	public void doSomething() {
		System.out.println("Doing something hidden from the public!");
	}
}
