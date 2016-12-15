json.extract! member, :id, :name, :address, :email, :phone, :password_digest, :created_at, :updated_at
json.url member_url(member, format: :json)