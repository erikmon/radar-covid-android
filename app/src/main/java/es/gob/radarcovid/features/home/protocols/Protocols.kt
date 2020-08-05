package es.gob.radarcovid.features.home.protocols

import es.gob.radarcovid.common.view.RequestView

interface HomeView : RequestView {

    fun showInitializationCheckAnimation()

    fun showExposureLevelLow()

    fun showExposureLevelHigh()

    fun showExposureLevelInfected()

    fun showBackgroundEnabled(enabled: Boolean)

    fun showWarningExposureNotificationsDisabled()

    fun hideWarningExposureNotificationsDisabled()

    fun showReportButton()

    fun hideReportButton()

    fun setRadarBlockChecked(isChecked: Boolean)

    fun areBatteryOptimizationsIgnored(): Boolean

    fun requestIgnoreBatteryOptimizations()

    fun showUnableToReportCovidDialog();

}

interface HomePresenter {

    fun viewReady(activateRadar: Boolean)

    fun onResume()

    fun onPause()

    fun onExposureBlockClick()

    fun onExposureNotificationsDisabledWarningClick()

    fun onReportButtonClick()

    fun onSwitchRadarClick(currentlyEnabled: Boolean)

    fun onBatteryOptimizationsIgnored()

}

interface HomeRouter {

    fun navigateToExpositionDetail()

    fun navigateToCovidReport()

    fun navigateToCovidReportConfirmation()

    fun navigateToExposureNotificationSettings()

}