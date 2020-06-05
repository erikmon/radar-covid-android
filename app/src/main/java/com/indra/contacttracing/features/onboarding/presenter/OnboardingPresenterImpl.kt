package com.indra.contacttracing.features.onboarding.presenter

import com.indra.contacttracing.datamanager.usecase.OnboardingCompletedUseCase
import com.indra.contacttracing.features.onboarding.protocols.ONBOARDING_PAGE_INDEX_STEP_3
import com.indra.contacttracing.features.onboarding.protocols.OnboardingPresenter
import com.indra.contacttracing.features.onboarding.protocols.OnboardingRouter
import com.indra.contacttracing.features.onboarding.protocols.OnboardingView
import javax.inject.Inject

class OnboardingPresenterImpl @Inject constructor(
    private val view: OnboardingView,
    private val router: OnboardingRouter,
    private val onboardingCompletedUseCase: OnboardingCompletedUseCase
) : OnboardingPresenter {

    override fun viewReady() {

    }

    override fun onBackButtonPressed() {
        view.showPreviousPage()
    }

    override fun onContinueButtonClick(page: Int, totalPages: Int) {
        when (page) {
            totalPages - 1 -> {
                onboardingCompletedUseCase.setOnboardingCompleted(true)
                router.navigateToMain()
                view.finish()
            }
            ONBOARDING_PAGE_INDEX_STEP_3 -> {
                if (view.isBluetoothEnabled())
                    view.showNextPage()
                else
                    view.showBluetoothRequest()
            }
            else -> {
                view.showNextPage()
            }
        }
    }

    override fun onBluetoothEnabled() {
        view.showNextPage()
    }

}