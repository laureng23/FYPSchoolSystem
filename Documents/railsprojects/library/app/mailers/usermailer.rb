class Usermailer < ApplicationMailer

  # Subject can be set in your I18n file at config/locales/en.yml
  # with the following lookup:
  #
  #   en.usermailer.welcome.subject
  #
    def welcome(member)
      @member = member
        mail(:to => member.email, :subject => "Thank you for registering")
  end
end
