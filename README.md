# datarest-spring-boot-expl

## Intro
Spring Data Rest demo project, to _play_ with:
- [AWS Elastic Beanstalk](https://aws.amazon.com/elasticbeanstalk/?nc2=h_ql_prod_cp_ebs)
- [AWS CodeBuild](https://aws.amazon.com/codebuild/?nc=sn&loc=0)

_(**Note**: test added on purpose to have better visibility of [AWS CodeBuild](https://aws.amazon.com/codebuild/?nc=sn&loc=0))_

## Fwks., Tools and Versions
- Java 1.8 _(Not 11 due to [AWS Elastic Beanstalk](https://aws.amazon.com/elasticbeanstalk/?nc2=h_ql_prod_cp_ebs) compatibility)_
- Spring Boot 2.1.8.RELEASE _(Actuator + Web + DevTools + Data JPA + Data Rest + H2)_
- [Lombok](https://projectlombok.org/) 1.18.1
- [AssertJ](https://joel-costigliola.github.io/assertj/) 3.13.2
- [Pragmatists/JUnitParams](https://github.com/Pragmatists/JUnitParams) 1.1.1

## References
- [Introduction to Spring Data Rest _(by Baeldung)_](https://www.baeldung.com/spring-data-rest-intro)
- [Using .ebextensions to extend nginx default configuration in AWS Elastic Beanstalk _(by medium)_](https://medium.com/swlh/using-ebextensions-to-extend-nginx-default-configuration-in-aws-elastic-beanstalk-189b844ab6ad)
- [Getting to Know and Love AWS Elastic Beanstalk Configuration Files (.ebextensions) _(by medium)_](https://medium.com/@marilu597/getting-to-know-and-love-aws-elastic-beanstalk-configuration-files-ebextensions-9a4502a26e3c)
- [How to configure AWS Beanstalk NGINX requests to redirect http to https _(by pushcommit.com)_](https://www.pushcommit.com/configure-aws-beanstalk-nginx-requests-to-redirect-http-to-https/)
- [Configuring the Proxy Server _(by docs.aws.amazon.com)_](https://docs.aws.amazon.com/elasticbeanstalk/latest/dg/nodejs-platform-proxy.html)
- [Configuring the Reverse Proxy _(by docs.aws.amazon.com)_](https://docs.amazonaws.cn/en_us/elasticbeanstalk/latest/dg/go-nginx.html)
- [Spring Boot JUnit example with RestTemplate](https://howtodoinjava.com/spring-boot2/testing/spring-boot-junit-resttemplate/)
- [Introduction to AWS CodeBuild](https://www.aws.training/Details/Video?id=16508)
- [Building your CI/CD Pipeline on AWS](https://medium.com/@octoz/building-your-ci-cd-pipeline-on-aws-8189800e8c96)
- [CodeDeploy Sample for CodeBuild](https://docs.aws.amazon.com/codebuild/latest/userguide/sample-codedeploy.html)
- [GitHub Pull Request and Webhook Filter Sample for CodeBuild](https://docs.aws.amazon.com/codebuild/latest/userguide/sample-github-pull-request.html)
- [https://dzone.com/articles/micro-services-automation-deployment-using-aws-and](https://dzone.com/articles/micro-services-automation-deployment-using-aws-and)

## Steps
- Build the distributable app with Maven _(.jar by default - .war if we want to have an specific nginx configu. file for AWS)_
- Deploy the distribution following the appropriate AWS Elastic Beanstalk instructions _(this will create an AWS EC2 with some default config)_
- Modify the `Security Groups\Inbound` assigned to the EC2 by adding the port exposed by the application  