package de.marhali.easyi18n.settings;

import com.intellij.testFramework.fixtures.BasePlatformTestCase;
import com.intellij.util.xmlb.XmlSerializerUtil;

import de.marhali.easyi18n.settings.presets.DefaultPreset;

/**
 * Tests for the project settings service itself.
 * @author marhali
 */
public class ProjectSettingsServiceTest extends BasePlatformTestCase {
    public void testSettingsDefaultPreset() {
        ProjectSettingsState state = ProjectSettingsService.get(getProject()).getState();
        assertEquals(state, new ProjectSettingsState(new DefaultPreset()));
    }

    public void testPersistenceState() {
        ProjectSettingsState previous = new ProjectSettingsState(new SettingsTestPreset());
        ProjectSettingsState after = XmlSerializerUtil.createCopy(previous);
        assertEquals(previous, after);
    }

    public void testPersistenceSingle() {
        ProjectSettingsState previous = new ProjectSettingsState();
        previous.setLocalesDirectory("mySinglePropTest");

        ProjectSettingsState after = XmlSerializerUtil.createCopy(previous);
        assertEquals("mySinglePropTest", after.getLocalesDirectory());
    }
}