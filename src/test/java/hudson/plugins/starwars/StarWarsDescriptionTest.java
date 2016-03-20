package hudson.plugins.starwars;

import static org.mockito.Mockito.mock;

import hudson.model.AbstractProject;
import junit.framework.TestCase;

public class StarWarsDescriptionTest extends TestCase {

	private StarWarsDescriptor descriptor;

	public void setUp() {
		descriptor = new StarWarsDescriptor();
	}

	public void testGetDisplayName() {
		assertEquals("Activate Star Wars", descriptor.getDisplayName());
	}

	public void testIsApplicableGivesTrue() {
		AbstractProject abstractProject = mock(AbstractProject.class);
		assertTrue(descriptor.isApplicable(abstractProject.getClass()));
	}
}
