package net.squanchy.settings

import androidx.appcompat.app.AppCompatActivity
import dagger.Component
import net.squanchy.analytics.Analytics
import net.squanchy.injection.BaseActivityComponentBuilder
import net.squanchy.injection.ActivityLifecycle
import net.squanchy.injection.ApplicationComponent
import net.squanchy.injection.applicationComponent
import net.squanchy.navigation.NavigationModule
import net.squanchy.navigation.Navigator
import net.squanchy.remoteconfig.RemoteConfig
import net.squanchy.signin.SignInModule
import net.squanchy.signin.SignInService
import net.squanchy.wificonfig.WifiConfigModule
import net.squanchy.wificonfig.WifiConfigService

internal fun settingsFragmentComponent(activity: AppCompatActivity): SettingsFragmentComponent =
    DaggerSettingsFragmentComponent.builder()
        .applicationComponent(activity.applicationComponent)
        .activity(activity)
        .build()

@ActivityLifecycle
@Component(modules = [SignInModule::class, NavigationModule::class, WifiConfigModule::class], dependencies = [ApplicationComponent::class])
interface SettingsFragmentComponent {

    fun navigator(): Navigator

    fun signInService(): SignInService

    fun analytics(): Analytics

    fun remoteConfig(): RemoteConfig

    fun wifiConfigService(): WifiConfigService

    @Component.Builder
    interface Builder : BaseActivityComponentBuilder<SettingsFragmentComponent>
}
