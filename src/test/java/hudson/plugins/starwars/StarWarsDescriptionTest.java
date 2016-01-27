package hudson.plugins.starwars;

import static org.mockito.Mockito.*;

import hudson.model.AbstractProject;
import hudson.plugins.starwars.StarWarsDescriptor;
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
