package com.teamsparta.seoulecommercemonitor.domain.store.model.v1

import com.teamsparta.seoulecommercemonitor.domain.store.dto.CsvResponse
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "seoul_online_shopping_mall_status")
class Csv(
    @Column(name = "business_name")
    val businessName: String,

    @Column(name = "mall_name")
    var mallName: String,

    @Column(name = "domain_name", length = 1024)
    val domainName: String,

    @Column(name = "phone_number")
    val phoneNumber: String,

    @Column(name = "operator_email")
    val operatorEmail: String,

    @Column(name = "sales_registration_number")
    val salesRegistrationNumber: String,

    @Column(name = "business_type")
    val businessType: String,

    @Column(name = "initial_report_date")
    val initialReportDate: String,

    @Column(name = "company_address")
    val companyAddress: String,

    @Column(name = "business_status")
    var businessStatus: String,

    @Column(name = "overall_evaluation")
    var overallEvaluation: String,

    @Column(name = "business_info_display_evaluation")
    val businessInfoDisplayEvaluation: String,

    @Column(name = "withdrawal_right_evaluation")
    val withdrawalRightEvaluation: String,

    @Column(name = "payment_method_evaluation")
    val paymentMethodEvaluation: String,

    @Column(name = "terms_of_service_evaluation")
    val termsOfServiceEvaluation: String,

    @Column(name = "personal_info_security_evaluation")
    val personalInfoSecurityEvaluation: String,

    @Column(name = "main_products")
    val mainProducts: String,

    @Column(name = "withdrawal_possibility")
    val withdrawalPossibility: String,

    @Column(name = "required_initial_screen_items")
    val requiredInitialScreenItems: String,

    @Column(name = "payment_methods")
    val paymentMethods: String,

    @Column(name = "compliance_with_terms_of_service")
    val complianceWithTermsOfService: String,

    @Column(name = "personal_info_handling_policy")
    val personalInfoHandlingPolicy: String,

    @Column(name = "request_for_additional_personal_info")
    val requestForAdditionalPersonalInfo: String,

    @Column(name = "purchase_safety_service")
    val purchaseSafetyService: String,

    @Column(name = "security_server_installation")
    val securityServerInstallation: String,

    @Column(name = "certification_mark")
    val certificationMark: String,

    @Column(name = "expected_delivery_date")
    val expectedDeliveryDate: String,

    @Column(name = "withdrawal_shipping_cost_burden")
    val withdrawalShippingCostBurden: String,

    @Column(name = "customer_complaint_board_operation")
    val customerComplaintBoardOperation: String,

    @Column(name = "membership_withdrawal_method")
    val membershipWithdrawalMethod: String,

    @Column(name = "site_establishment_year")
    val siteEstablishmentYear: String,

    @Column(name = "monitoring_date")
    var monitoringDate: String,

    ) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}

fun Csv.toCsvResponse(): CsvResponse = CsvResponse(
    id = id!!,
    businessName = businessName,
    overallEvaluation = overallEvaluation,
    businessStatus = businessStatus,
    monitoringDate = monitoringDate
)
