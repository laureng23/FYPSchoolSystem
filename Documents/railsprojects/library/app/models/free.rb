class Free < ActiveRecord::Base
    mount_uploader :attachment, AttachmentUploader
 
end
