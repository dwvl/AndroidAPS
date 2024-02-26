package app.aaps.plugins.source

import android.content.Context
import androidx.preference.PreferenceCategory
import androidx.preference.PreferenceManager
import androidx.preference.PreferenceScreen
import app.aaps.core.interfaces.logging.AAPSLogger
import app.aaps.core.interfaces.plugin.PluginBase
import app.aaps.core.interfaces.plugin.PluginDescription
import app.aaps.core.interfaces.resources.ResourceHelper
import app.aaps.core.interfaces.source.BgSource
import app.aaps.core.keys.AdaptiveSwitchPreference
import app.aaps.core.keys.BooleanKey

abstract class AbstractBgSourceWithSensorInsertLogPlugin(
    pluginDescription: PluginDescription,
    aapsLogger: AAPSLogger,
    rh: ResourceHelper
) : PluginBase(pluginDescription, aapsLogger, rh), BgSource {

    override fun addPreferenceScreen(preferenceManager: PreferenceManager, parent: PreferenceScreen, context: Context) {
        val category = PreferenceCategory(context)
        parent.addPreference(category)
        category.apply {
            key = "bg_source_upload_settings"
            title = rh.gs(R.string.bgsource_upload)
            initialExpandedChildrenCount = 0
            addPreference(AdaptiveSwitchPreference(ctx = context, booleanKey = BooleanKey.BgSourceUploadToNs, title = app.aaps.core.ui.R.string.do_ns_upload_title))
            addPreference(AdaptiveSwitchPreference(ctx = context, booleanKey = BooleanKey.BgSourceCreateSensorChange, summary = R.string.dexcom_log_ns_sensor_change_summary, title = R.string.dexcom_log_ns_sensor_change_title))
        }
    }
}
