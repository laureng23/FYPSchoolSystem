json.extract! management, :id, :username, :password_digest, :created_at, :updated_at
json.url management_url(management, format: :json)