Perigon Project System design with LLD  
￼
 
￼
High-Level Design (HLD) Overview:
1. Components & Services:
    * File Collector: Aggregates files from payment processors.
    * File Processor: Processes these files, transforming and normalizing data.
    * Recon FileStore & Data Joiner: Handles reconciliation processes, joining data from various sources.
    * Settlement Reconciler: Ensures that settlements match across systems.
    * Payment Visualizations Service: Provides a UI or dashboard to visualize payment-related data.
    * Amazon S3 & SNS: Used extensively for data storage, event-driven processing, and communication between services.
2. Data Flow:
    * Internal Data Flow: Movement of data within the system, like between the file processor and data joiner.
    * External Data Flow: Interaction with external systems, such as fetching data from payment processors.
    * Combined Data Flow: Where both internal and external data are used together, such as in reconciliation processes.
3. Architecture Style:
    * Event-Driven Architecture: Many components interact through Amazon SNS and SQS, which are event-driven, ensuring that actions are taken in response to specific events.
    * Microservices: The architecture is likely microservices-based, with each component handling a specific part of the reconciliation and reporting process.
Low-Level Design (LLD) Insights:
1. Service Communication:
    * SQS/SNS: Used for decoupling services and ensuring asynchronous communication.
    * APIs: Services likely communicate over well-defined APIs for fetching, processing, and storing data.
2. Data Handling:
    * File Formats: Handling different file formats from payment processors.
    * Data Transformations: How data is transformed from raw input to processed output.
3. Error Handling:
    * Retries & Dead Letter Queues: Built-in mechanisms for handling failures, like retries in SQS or dead-letter queues.
Sample System Design Questions:
1. Service Isolation and Scalability:
    * How would you ensure that each microservice can scale independently without affecting the overall system?
    * What strategies would you use to handle large volumes of incoming files from payment processors?
2. Data Consistency and Reliability:
    * How would you design the system to ensure data consistency across the file processing and reconciliation pipeline?
    * In the case of a failure during the reconciliation process, how would you ensure that no data is lost?
3. Performance Optimization:
    * Given the need to process large volumes of transactions, how would you optimize the performance of the file processor and reconciler?
    * What caching strategies might be employed to reduce latency in the payment visualizations service?
4. Security and Compliance:
    * How would you ensure that sensitive payment data is securely transmitted and stored across services?
    * What compliance considerations would you need to take into account when handling payment data?
5. Event-Driven Processing:
    * How would you design the event-driven architecture to ensure that events are processed in the correct order?
    * What would happen if an event is lost or not processed in the system?
High-Level Design (HLD) and Low-Level Design (LLD) Example:
1. HLD Example:
    * Diagram: A high-level diagram showing the key services (File Collector, Processor, Reconciler, etc.) and how they interact through SQS/SNS, S3, and the database.
    * Narrative: An overview of how a transaction file flows through the system, from collection to reconciliation and reporting.
2. LLD Example:
    * Detailed Flow: A detailed flow diagram showing the interactions within a specific service, like the File Processor, including the data transformations, API calls, and error handling.
    * Code Snippets: Sample code or pseudocode showing how a service might process a file, transform data, and handle exceptions.
I can also generate diagrams or sketches based on the architecture shown in the screenshots if that would help. Let me know if you need further details or any specific diagrams.



File Collector
Current Issues with Control-M:
* Operational disruptions
* Difficulty identifying failures
* Redundant job setups
Service Goals:
* Accuracy: Ensure correct data delivery
* Availability: Reliable operation even if parts fail
* Completeness: Deliver all data without missing files
* Resiliency: Handle errors without affecting other operations
* Idempotence: Consistent outcomes for repeated file processing
* Scalability: Handle increased demand with additional resources
Functional Requirements:
* File Downloading: Download from locations like SFTP servers
* Duplicate File Detection: Avoid reprocessing duplicates
* Audit Trail: Record all actions (files received and delivered)
* New Data Only: Process only new or modified files
* Job Configurations: Support various sources and customizable jobs
* File Modification: Ability to modify files at the source
Future Features:
* Adhoc Requests: Custom job configurations
* More Sources/Destinations: Support for additional types
* Web Dashboard: Future management and monitoring dashboard
Out of Scope:
* Decryption/Renaming: Not handled
* Multiple Destinations: Initially only Amazon S3
* Automatic Job Configuration Updates: Manual changes only
* Immediate Job Triggering: Jobs run on a set schedule
Credentials Management:
* Vault Storage: Secure credential storage managed by operations team
File Collector Workflow:
1. Job Setup: Reads configurations and credentials
2. Polling: Checks SFTP for files
3. Filtering: Excludes already processed files
4. Verification: Ensures files haven’t changed (MD5 hash check)
5. Delivery: Uploads new files to an S3 bucket
6. Deduplication: Checks MD5 hash to avoid duplicate delivery
File Delivery Details:
* Destination: S3 bucket, organized by job name and date
* Frequency: Based on job schedule
* Access: Read-only access for downstream users
* Data Retention: Same as current policy for similar files
 File Processor

￼
High-Level Design (HLD)
1. File Collection and Delivery
    * S3 to SFTP Recon Files: Managed by a dedicated message handler. Designed for modularity to facilitate easy removal when transitioning to the new recon service.
    * PTX Data Stream to SFTP: Uses a single SQS notification for creation in S3 directories, resulting in files being delivered to one SFTP folder only.
2. File Processing and Jobs
    * Chase vs. Adyen Files: Different jobs configured for different processors. Chase processes settlementFile and chargebackSettlementFile separately, while Adyen combines them.
    * Fraud Files: chargebackActivityFeedJob processes fraud files from various processors, normalizes them, and delivers them to the data joiner.
Low-Level Design (LLD)
1. Message Handlers
    * Recon File Handler: A separate handler with minimal coupling to major components, ensuring easy removal and adaptation.
    * PTX Data Handler: Manages file transit from S3 to SFTP using a single SQS notification.
2. Processor Jobs Configuration
    * ChaseProcessor: Separate jobs for settlementFile and chargebackSettlementFile.
    * AdyenProcessor: Combined file job for settlement data.
    * FraudProcessor: Special job chargebackActivityFeedJob for fraud file normalization and delivery.
Areas for Improvement
1. Documentation
    * Enhance to include detailed system and coding guidelines.
    * Create a team coding style convention.
2. Code Readability
    * Improve naming conventions to increase clarity.
3. Testing
    * Add unit tests for transformers and validators to ensure robustness.
4. Code Maintenance
    * Clean up code, including refactoring classes like ChaseSettlementTransformer for better readability and maintainability.
  File-Combiner
￼
Overview
The File Combining Service consolidates settlement batches from multiple files into one, based on a defined settlement batch criteria (processor + MID + date). The service handles scenarios where processors, like Chase, may send batch data in multiple files. The aim is to produce a single normalized file with complete and accurate settlement details and summary records.
Benefits
1. Complete Batches: Ensures that settlement batches are complete before ingestion, preventing errors and incomplete data from being processed.
2. Fee Allocation: Manages fee allocation at the batch level, which is crucial for processors like Chase where fees reported in one file may need to be allocated to transactions in another.
3. Timely Data: Reduces delays by waiting for all relevant files before processing, ensuring timely and accurate settlement data.
4. Accurate Disbursement: Allows accurate calculation for disbursement by including chargebacks in the same file, which helps in the precise allocation of funds.
Requirements
1. Separate Service: Develop a dedicated File Combiner service to:
    * Reusability: Ensure that the input to the File Combiner is normalized, reducing the need for major changes in each file processor.
    * Flexibility: Handle the timing of file arrivals more efficiently.
2. Normalized Output: Produce a single normalized file combining all settlement details from separate files.
3. Processor-Agnostic: Keep the service as processor-agnostic as possible to simplify onboarding of new processors.
Example
For Chase, three settlement files are provided:
* Chargeback File: 201937.0000269763.201008.d.A024.dfr_resp.pgp
* Transaction File: 201937.0000269763.201008.d.B249.dfr_resp.pgp
* Deposit File: 201937.0000269763.201008.d.H016.dfr_resp.pgp
The File Processor generates two files for each MID:
1. Chargeback Normalized: PAYSettlement_CHASE_20201008-371878-CB_normalized.jsonl
2. Other Transactions Normalized: PAYSettlement_CHASE_20201008-371878_normalized.jsonl
Combined Output File:
* The output file consolidates all transaction details and summary records from the partial files into a single normalized file.
Approaches
File Routing
Solution 1: File Level Check (Preferred)
* Description: Add an attribute to the DynamoDB table to track settlement batch IDs from each file. After processing, route partial files to an S3 bucket if necessary. Notifications are sent to the File Combiner once all expected files have arrived.
* Pros:
    * Does not rely on file data content.
    * Reuses existing infrastructure (DynamoDB table).
    * Simplifies tracking.
* Cons:
    * File name changes require configuration updates.
    * Notifications are sent even if no combining is needed.
Solution 2: Record Level Check
* Description: Determine if multiple files are expected by examining the records in the file. Track batch details in a new DynamoDB table. Process files and update records based on the report type (chargeback or transaction). Route partial files accordingly.
* Pros:
    * Tracks record-level details for more precise processing.
* Cons:
    * Requires additional infrastructure (new DynamoDB table).
    * More complex implementation.
Summary
The File Combining Service aims to consolidate settlement data efficiently, ensuring complete and accurate batch processing. The chosen approach should balance flexibility, reusability, and operational complexity.


Data Joiner
￼
Introduction
The GCP payment systems generate critical data that helps form a complete picture of payment transactions. Consumers of payment data need to verify if transactions are processed or settled successfully and check for any chargebacks. Data Joiner links external data from payment gateways or processors with internal payment records to provide a comprehensive view of payment activities. This document details the design of the Data Joiner service.

Service Tenets
* Accuracy: Ensure precise linking of external data with internal data.
* Availability: Maintain full redundancy to ensure service quality and uptime.
* Completeness: Guarantee the completeness of both internal and external data.
* Resiliency: Fault tolerance to ensure errors in one operation don’t affect others.
* Idempotent: Ensure that receiving the same data multiple times results in the same outcome.
* Scalability: Support horizontal scalability to accommodate growing processing demands.

Requirements
Functional Requirements:
* Support data from both internal payment services and external vendors.
* Join internal payment records with processor data including settlement, chargebacks, refunds, credits, and deposits.
* Handle data ingestion and processing regardless of the order received.
* Route joined data based on the source region.
* Republish unmatched data (details to be scoped).
Operational Requirements:
* Ensure data persists through service restarts.
* Retain data for a defined period.
* Implement disaster recovery, logging, metrics, and dashboard monitoring.

System Design
Data Joiner is integrated within the payment infrastructure with a global cluster serving all PX/PTX regions. It works alongside File Processor, using AWS S3 + SQS for reliable file handling and messaging.
Components:
* Stream Handler: Reads and acknowledges messages from the stream.
* File Handler: Receives SQS messages and processes files from S3.
* Data Persistence: Manages and stores data from various sources.
* Data Join/Process: Joins or matches data based on the type and processor.
* Data Publish: Publishes matched or unmatched data to appropriate targets.

Data Publish
* Matched Data: Delivered to PtxRepo via update API.
* Unmatched Data: Options for publishing:
    * Option 1: Separate Kinesis Stream for unmatched data.
    * Option 2: Publish to PtxRepo, with considerations for complexity and notifications.

Error Handling
* Retry Mechanism: Fail transactions or keep flags for unprocessed data to ensure eventual delivery.
* Error Recovery: Mechanisms to handle fundamental issues or reprocess data.

Data Retention Policy
Aligned with PTX Repo policies for data retention and purging.  

Settlement-Reconciler
￼
The Settlement Reconciler Service is a critical microservice within a cluster responsible for generating final settlement files for EGP (Enterprise Gateway Platform). Its role is to enrich, process, and reconcile settlement data, while managing statistics and creating multiple output files based on business rules.
Requirements
1. Enrichment and Reconciliation:
    * Enrich each settlement line with a reconciliation attribute (reconciled/unreconciled).
    * For settlements associated with a PayMID, create a normalized settlement file for the PayMID and include reconciled settlements only.
    * Generate a separate file for unreconciled PayMID settlements for manual review.
    * Log appropriate messages to configure Splunk alerts.
2. Summary Records:
    * Create summary records for PayMID settlements, including fee allocations and other attributes.
    * Persist summary records and batch statistics into a datastore.
3. Unmatched Settlements:
    * Identify and persist unmatched settlements (without PXContext).
    * Optionally, create timeseries records for unmatched settlements.
Design
The service leverages the Spring Batch File Processing Framework to handle the file processing, splitting, and transformation tasks. It follows a pattern similar to a file processor, focusing on reconciliation, fee allocation, and statistical persistence.
Components:
1. Spring Batch File Processing Framework:
    * Input: Enriched PAYSettlement file from Data Joiner.
    * Output: Final settlement files for external consumption (e.g., VRBO, EGC, BI).
    * Process: Generates separate files for reconciled PayMID settlements and unreconciled settlements, including appropriate logging.
2. Recon Library:
    * Purpose: Enhance settlement records with reconciliation details.
    * Includes Rules: Fee tolerance, FX tolerance, etc.
3. Settlement Batch Metrics Determination/Persistence:
    * Purpose: Track and persist statistics of settlement batches (e.g., reconciled, unreconciled, reconciled_with_error).
    * Output: Statistics saved to a database.
4. Summary Fee Allocation:
    * Purpose: Distribute summary fees across PayMIDs or other attributes.
    * Output: Summary records per PayMID saved to a database.
5. API Component:
    * Endpoints:
        * Statistics APIs: Retrieve metrics on settlements and batches.
        * Unmatched Settlements API: Access unmatched settlement data.
        * PayMID Batch Status API: Check and update PayMID batch statuses.
        * Settlement Batch File API: Get settlement batch files from S3.


 
